/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.jdc.mtp;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            try {
                /* the code */
                // user.dir
                JFrame frame = new JFrame("SVG test");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(800, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
