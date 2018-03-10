package com.laowuandhisfriends.chat;

import java.io.BufferedWriter;
import java.util.LinkedList;

public class ClientWriteThread implements Runnable {
    private BufferedWriter bw;
    private LinkedList<String> message;

    public ClientWriteThread(BufferedWriter bw, LinkedList<String> message) {
        this.bw = bw;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                if (message.size() != 0) {
                    bw.write(message.poll() + "\r\n");
                    bw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
