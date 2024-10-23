package com.jjk.gcalc.ui;

import javax.swing.*;
import java.awt.*;

import static com.jjk.gcalc.ui.SwingHelper.*;

public class FunctionPanel extends JPanel {

    public FunctionPanel() {
        setLayout(new GridBagLayout());

        JButton addBtn = new JButton("Add New Function");
        scaleFont(addBtn);
        add(addBtn, new GBC().pad(10).insets(10));
    }
}
