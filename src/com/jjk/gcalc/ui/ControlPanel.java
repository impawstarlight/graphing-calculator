package com.jjk.gcalc.ui;

import com.jjk.gcalc.ui.SwingHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    GBC gbc;

    public ControlPanel() {
        setPreferredSize(new Dimension(240, 0));
        setLayout(new GridBagLayout());
        gbc = new GBC().fill(GBC.HORIZONTAL).weightx(1);

        // "Viewport" label at the top with separator
        JLabel viewportLabel = new JLabel("Viewport");
        viewportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(viewportLabel, gbc.x(0).y(0).width(2));
        add(new JSeparator(), gbc.y(1));

        // "Width" label + Spinner
        JLabel widthLabel = new JLabel("Width");
        widthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JSpinner widthSpinner = createSpinner(10, 0, Integer.MAX_VALUE, 1);
        add(widthLabel, gbc.x(0).y(2).width(1).anchor(GBC.EAST));
        add(widthSpinner, gbc.x(1).y(2).fill(GBC.HORIZONTAL));

        // "Height" label + Spinner
        JLabel heightLabel = new JLabel("Height");
        heightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JSpinner heightSpinner = createSpinner(10, 0, Integer.MAX_VALUE, 1);
        add(heightLabel, gbc.x(0).y(3).width(1).anchor(GBC.EAST));
        add(heightSpinner, gbc.x(1).y(3).fill(GBC.HORIZONTAL));

        // "Center" label with separator
        JLabel centerLabel = new JLabel("Center");
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(centerLabel, gbc.x(0).y(4).width(2));
        add(new JSeparator(), gbc.y(5));

        // "X" label + Spinner
        JLabel xLabel = new JLabel("X");
        xLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JSpinner xSpinner = createSpinner(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
        add(xLabel, gbc.x(0).y(6).width(1).anchor(GBC.EAST));
        add(xSpinner, gbc.x(1).y(6).fill(GBC.HORIZONTAL));

        // "Y" label + Spinner
        JLabel yLabel = new JLabel("Y");
        yLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JSpinner ySpinner = createSpinner(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
        add(yLabel, gbc.x(0).y(7).width(1).anchor(GBC.EAST));
        add(ySpinner, gbc.x(1).y(7).fill(GBC.HORIZONTAL));

        add(Box.createVerticalGlue(), gbc.y(20).weighty(1));
    }

    private JSpinner createSpinner(int value, int min, int max, int step) {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, step)); // Default value, min, max, step
        spinner.setPreferredSize(new Dimension(80, spinner.getPreferredSize().height)); // Set fixed width for spinner
        return spinner;
    }


}
