package com.jjk.gcalc;

import com.jjk.gcalc.ui.GraphPanel;

import javax.swing.JPanel;

public class Singleton {
    private JPanel functionListPanel;
    private GraphPanel graphPanel;

    private static Singleton instance;

    private Singleton() {}

    public static void init() {
        if (instance == null) {
            instance = new Singleton();
        }
    }

    public static void setFunctionListPanel(JPanel panel) {
        instance.functionListPanel = panel;
    }

    public static void setGraphPanel(GraphPanel gPanel) {
        instance.graphPanel = gPanel;
    }

    public static void updatePlot() {
        instance.graphPanel.setFComponents(instance.functionListPanel.getComponents());
    }
}
