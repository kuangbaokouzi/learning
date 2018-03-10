package com.laowuandhisfriends.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;

public class FrameServerReadThread implements Runnable {
    private Socket socket;
    private BufferedReader br;
    private String address;

    public FrameServerReadThread(Socket socket) {
        this.socket = socket;
        this.address = socket.getRemoteSocketAddress().toString();
        try {
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("服务器读线程开始...");
            String line;
            while (true) {
                line = br.readLine();
                System.out.println(line);
                if (line != null) {
                    LinkedList<String> message = FrameThreadServer.map.get(socket);
                    if (message.size() == 0) {// 该socket第一次发送消息
                        message.add(line);
                    } else {
                        message.add(line);// 后续发送消息
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
