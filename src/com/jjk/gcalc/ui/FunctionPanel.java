package com.jjk.gcalc.ui;

import com.jjk.gcalc.ui.SwingHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class FunctionPanel extends JPanel {

    public FunctionPanel() {
        JButton addButton = new JButton("Add Function");
        FunctionList listPanel = new FunctionList();

        addButton.addActionListener(actionEvent -> listPanel.addFunctionComponent());

        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");



        setPreferredSize(new Dimension(480, 480));
        setLayout(new GridBagLayout());

        GBC gbc = new GBC();
        add(addButton, gbc.x(1).y(0).weightx(1));
        add(loadButton, gbc.x(0).y(2).weightx(0));
        add(saveButton, gbc.x(2).y(2));
        add(listPanel, gbc.x(0).y(1).width(3).fill(GBC.BOTH).weightx(1).weighty(1).pad(0).insets(0));
    }
}
