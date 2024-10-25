package com.jjk.gcalc.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        add(new FunctionPanel(), BorderLayout.WEST);
        add(new GraphPanel(), BorderLayout.CENTER);
        add(new ControlPanel(), BorderLayout.EAST);


        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
