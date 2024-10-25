package com.jjk.gcalc;

import com.formdev.flatlaf.FlatLightLaf;
import com.jjk.gcalc.ui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Theme and Font setup
        FlatLightLaf.setup();
        Font defaultFont = UIManager.getFont("defaultFont");
        UIManager.put("defaultFont", defaultFont.deriveFont(defaultFont.getSize2D() * 1.5f));


        Singleton.init();
        new MainWindow();


    }
}
