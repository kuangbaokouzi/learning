package com.laowuandhisfriends.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClientFrame {
    private JFrame jFrame;
    private JButton jButton;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;

    public ClientFrame() {
        jFrame = new JFrame();
        jFrame.setTitle("群聊窗口");
        jFrame.setBounds(400, 200, 400, 300);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextAreaInit();
        JButtonInit();

        jFrame.setVisible(true);
    }

    public void jButtonEvent(LinkedList<String> messageFromLocal) {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextArea2.getText() == null || "".equals(jTextArea2.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "请先填写发送内容", "警告", JOptionPane.WARNING_MESSAGE);
                    jTextArea2.setFocusable(true);// 获得焦点
                    return;
                }
                messageFromLocal.add(jTextArea2.getText());
                jTextArea2.setText("");
            }
        });
    }

    private void JButtonInit() {
        jButton = new JButton("发送");
        jButton.setBounds(310, 160, 80, 100);
        jFrame.add(jButton);
    }

    private void JTextAreaInit() {
        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(0, 0, 400, 150);
        jTextArea1.setBackground(Color.WHITE);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea2 = new JTextArea();
        jTextArea2.setBounds(0, 160, 300, 100);
        jTextArea2.setBackground(Color.WHITE);
        jFrame.add(jTextArea1);
        jFrame.add(jTextArea2);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextArea getjTextArea2() {
        return jTextArea2;
    }

    public void setjTextArea2(JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }
}
