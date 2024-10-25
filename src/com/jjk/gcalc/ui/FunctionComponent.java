package com.jjk.gcalc.ui;

import com.jjk.gcalc.Singleton;

import javax.swing.*;
import java.awt.*;

import static com.jjk.gcalc.ui.SwingHelper.GBC;

public class FunctionComponent extends JPanel {

    private final JCheckBox checkBox;
    private final JButton colorButton;
    private final JTextField functionField;

    //    private FunctionList parent;
    private final RemoveHandler parent;

    public interface RemoveHandler {
        void removeFunctionComponent(FunctionComponent fc);
    }

    public FunctionComponent() {
        this(null);
    }

    public FunctionComponent(RemoveHandler par) {
        parent = par;

        checkBox = new JCheckBox();
        checkBox.setSelected(true);
        checkBox.addActionListener(e -> Singleton.updatePlot());

        colorButton = new JButton(" ");
        colorButton.setBackground(Color.BLUE);

        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(FunctionComponent.this, "Choose Plot Color", colorButton.getBackground());
            if (selectedColor != null) {
                colorButton.setBackground(selectedColor);
                Singleton.updatePlot();
            }
        });

        functionField = new JTextField();
        functionField.addActionListener(e -> Singleton.updatePlot());

        JButton removeButton = new JButton("✖"); // Unicode character for a cross (✖)
        removeButton.setFocusPainted(false);

        removeButton.addActionListener(e -> {
            if (parent != null)
                parent.removeFunctionComponent(FunctionComponent.this);
        });


//        setPreferredSize(new Dimension(480, 48));
//        setMinimumSize(new Dimension(320, 48));

        // Add components to the panel with constraints
        setLayout(new GridBagLayout());
        GBC gbc = new GBC();

        add(checkBox, gbc.x(0).pad(0));
        add(colorButton, gbc.x(1).insets(4));
        add(functionField, gbc.x(2).weightx(1).fill(GBC.HORIZONTAL));
        add(removeButton, gbc.x(3).weightx(0).fill(GBC.NONE));
    }

    public String getFunctionText() {
        return functionField.getText();
    }

    public Color getPlotColor() {
        return colorButton.getBackground();
    }

    public boolean isPlotEnabled() {
        return checkBox.isSelected();
    }
}
