package com.jjk.gcalc.ui;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Tmp {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        // Create a JFrame
        JFrame frame = new JFrame("Menu Bar Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu and add items
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(fileMenu);

        // Set the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Add other components to the frame (using any layout manager)
        JPanel panel = new JPanel(); // Default is FlowLayout
        JButton button = new JButton("Click Me");
        panel.add(button);
        frame.add(panel); // Add the panel to the content pane

        // Make the frame visible
        frame.setVisible(true);
    }
}
