package com.jjk.gcalc.ui;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

import static com.jjk.gcalc.ui.SwingHelper.*;

public class MainWindow {
    public static void main(String[] args) {
        FlatLightLaf.setup();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(720, 320);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        FunctionPanel fp = new FunctionPanel();
        panel.add(fp, makeGBC(0, 0, 1, 1, 0, GridBagConstraints.VERTICAL));
        panel.setBackground(new Color(224, 192, 255));

        JButton button = new JButton("Abracadrabra");
        scaleFont(button);
        panel.add(button, makeGBC(0, 0, 3, 1));

        button = new JButton("Cadabra");
        scaleFont(button, 1.25f);
        panel.add(button, makeGBC(0, 1, 4, 1));



//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
