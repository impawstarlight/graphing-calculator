package com.jjk.gcalc.ui;

import javax.swing.*;
import java.awt.*;

public class SwingHelper {

    public static void scaleFont(JComponent component) {
        scaleFont(component, 1.25f);
    }

    public static void scaleFont(JComponent component, float factor) {
        Font font = component.getFont();
        Font scaledFont = font.deriveFont(font.getSize2D() * factor);
        component.setFont(scaledFont);
    }


    static GridBagConstraints makeGBC(int x, int y) {
        return makeGBC(x, y, 1, 1);
    }

    static GridBagConstraints makeGBC(int x, int y, int w, int h) {
        return makeGBC(x, y, w, h, 0);
    }

    static GridBagConstraints makeGBC(int x, int y, int w, int h, int p) {
        return makeGBC(x, y, w, h, p, GridBagConstraints.NONE);
    }

    static GridBagConstraints makeGBC(int x, int y, int w, int h, int p, int f) {
        return makeGBC(x, y, w, h, p, f, GridBagConstraints.CENTER);
    }
    static GridBagConstraints makeGBC(int x, int y, int w, int h, int p, int f, int a) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.fill = f;
        gbc.anchor = a;
        gbc.ipadx = gbc.ipady = p;
        gbc.insets = new Insets(p, p, p, p);
        return gbc;
    }

    static class GBC extends GridBagConstraints {
        GBC x(int x) {
            gridx = x;
            return this;
        }
        GBC y(int y) {
            gridy = y;
            return this;
        }

        GBC width(int w) {
            gridwidth = w;
            return this;
        }
        GBC height(int h) {
            gridheight = h;
            return this;
        }

        GBC fill(int f) {
            fill = f;
            return this;
        }
        GBC anchor(int a) {
            anchor = a;
            return this;
        }

        GBC pad(int p) {
            return padx(p).pady(p);
        }
        GBC padx(int px) {
            ipadx = px;
            return this;
        }
        GBC pady(int py) {
            ipady = py;
            return this;
        }

        GBC insets(int p) {
            insets = new Insets(p, p, p, p);
            return this;
        }
        GBC insets(int p, int q, int r, int s) {
            insets = new Insets(p, q, r, s);
            return this;
        }


    }
}
