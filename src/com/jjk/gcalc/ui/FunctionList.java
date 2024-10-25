package com.jjk.gcalc.ui;

import com.jjk.gcalc.Singleton;
import com.jjk.gcalc.ui.SwingHelper.GBC;

import javax.swing.*;
import java.awt.*;

public class FunctionList extends JScrollPane implements FunctionComponent.RemoveHandler {
    JPanel panel;
    GBC gbc;

    public FunctionList() {
        panel = new JPanel(new GridBagLayout());
        gbc = new GBC().x(0).y(GBC.RELATIVE).weightx(1).fill(GBC.HORIZONTAL);

        panel.add(Box.createVerticalGlue(), gbc.weighty(1));
        gbc.weighty(0);

        setViewportView(panel);
        Singleton.setFunctionListPanel(panel);
    }

    public void addFunctionComponent() {
        panel.remove(panel.getComponentCount() - 1);
        panel.add(new FunctionComponent(this), gbc);
        panel.add(Box.createVerticalGlue(), gbc.weighty(1));
        gbc.weighty(0);

        // Revalidate and repaint the panel to reflect the changes
        panel.revalidate();
        panel.repaint();
//        Singleton.setFComponents(panel.getComponents());
        Singleton.updatePlot();
    }

    public void removeFunctionComponent(FunctionComponent component) {
        panel.remove(component);
        panel.revalidate();
        panel.repaint();
        Singleton.updatePlot();
    }

}
