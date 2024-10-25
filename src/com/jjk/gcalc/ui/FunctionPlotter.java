package com.jjk.gcalc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FunctionPlotter extends JPanel {

    private final double[] functionValues;

    public FunctionPlotter() {
        // Example: Calculate function values for y = x^2
        functionValues = new double[500];
        for (int x = 0; x < functionValues.length; x++) {
            double normalizedX = (x / (double) functionValues.length) * 10 - 5; // Scale to [-5, 5]
            functionValues[x] = normalizedX * normalizedX; // y = x^2
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the axes
        g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); // X axis
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // Y axis

        // Draw the function
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < functionValues.length - 1; i++) {
            int x1 = i;
            int y1 = (int) (getHeight() / 2 - functionValues[i] * 20); // Scale factor for visibility
            int x2 = i + 1;
            int y2 = (int) (getHeight() / 2 - functionValues[i + 1] * 20);
            // TODO check double precision
            g2d.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 400);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Function Plotter");
        FunctionPlotter plotter = new FunctionPlotter();
        frame.add(plotter);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
