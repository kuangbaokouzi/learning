package com.laowuandhisfriends.chat;

import java.io.BufferedReader;

public class ClientReadThread implements Runnable {
    private BufferedReader br;
    private ClientFrame clientFrame;

    public ClientReadThread(BufferedReader br, ClientFrame clientFrame) {
        this.br = br;
        this.clientFrame = clientFrame;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = br.readLine();
                if (line != null)
                    clientFrame.getjTextArea1().setText(clientFrame.getjTextArea1().getText() + "\r\n" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
