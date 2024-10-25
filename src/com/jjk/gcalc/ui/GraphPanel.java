package com.jjk.gcalc.ui;

import com.jjk.gcalc.FunctionEvaluator;
import com.jjk.gcalc.Singleton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Line2D;

public class GraphPanel extends JPanel {
    public double graphWidth;
    public double graphHeight;
    public double centerX;
    public double centerY;

    private Component[] fComponents;

    public GraphPanel() {
        Singleton.setGraphPanel(this);
        fComponents = new Component[0];

        setPreferredSize(new Dimension(640, 640));
        setBorder(new LineBorder(Color.GRAY, 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clears the canvas

        graphWidth = getWidth() / 100.0;
        graphHeight = getHeight() / 100.0;
        centerX = centerY = 0;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        updatePlot(g2d);
    }


    public void updatePlot(Graphics2D g2d) {
        drawAxes(g2d);

        // Loop through each FunctionComponent
        for (int i = 0; i < fComponents.length-1; i++) {
            FunctionComponent fc = (FunctionComponent) fComponents[i];
            if (!fc.isPlotEnabled()) continue;

            String equation = fc.getFunctionText();
            if (!equation.isEmpty()) {
                try {
                    FunctionEvaluator evaluator = new FunctionEvaluator(equation);
                    plotFunction(g2d, evaluator, fc.getPlotColor());
                } catch (Exception e) {
                    // alert invalid input
                }
            }
        }
    }

    private void drawAxes(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        int width = getWidth();
        int height = getHeight();

        // X-axis (horizontal)
        int xAxisY = height / 2 + (int) centerY;
        g2d.drawLine(0, xAxisY, width, xAxisY);

        // Y-axis (vertical)
        int yAxisX = width / 2 + (int) centerX;
        g2d.drawLine(yAxisX, 0, yAxisX, height);
    }

    private void plotFunction(Graphics2D g2d, FunctionEvaluator evaluator, Color color) {
        g2d.setColor(color);  // Set the color for plotting the function
        g2d.setStroke(new BasicStroke(4));

        int width = getWidth();
        int height = getHeight();

        double xMin = -graphWidth / 2 + centerX;
        double xMax = graphWidth / 2 + centerX;

        // Step size for plotting points (smaller step = smoother curve)
        double step = (xMax - xMin) / width;

        // Previous point for drawing lines
        double prevX = xMin;
        double prevY = evaluator.evaluate(prevX);

        // Convert graph space to screen space
        double scaleX = width / graphWidth;
        double scaleY = height / graphHeight;

        for (double x = xMin + step; x <= xMax; x += step) {
            double y = evaluator.evaluate(x);

            // Screen coordinates
            // TODO check double precision
            int screenX1 = (int) ((prevX - centerX) * scaleX + width / 2);
            int screenY1 = (int) (height / 2 - (prevY - centerY) * scaleY);
            int screenX2 = (int) ((x - centerX) * scaleX + width / 2);
            int screenY2 = (int) (height / 2 - (y - centerY) * scaleY);

            // Draw line segment from (prevX, prevY) to (x, y)
            g2d.draw(new Line2D.Double(screenX1, screenY1, screenX2, screenY2));

            // Update previous points
            prevX = x;
            prevY = y;
        }
    }

    public void setFComponents(Component[] components) {
        fComponents = components;
        repaint();
    }
}
