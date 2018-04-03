package com.laowuandhisfriends.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Frame");
        JButton jButton = new JButton("My Button");

        jButton.addActionListener(event -> {
            System.out.println("Button Pressed!");
        });

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
