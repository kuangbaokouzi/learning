package com.laowuandhisfriends.chat;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

public class FrameServerWriteThread implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                if (FrameThreadServer.map.size() == 0)// 客户端可能建立了连接，但是没有人发送消息
                    continue;
                //  有人发送过消息，遍历socket
                for (Socket socket : FrameThreadServer.map.keySet()) {
                    LinkedList<String> message = FrameThreadServer.map.get(socket);// 拿到每个socket对应的消息组
                    while (message.size() != 0) {
                        if (message.peek() != null) {
                            for (Socket s2 : FrameThreadServer.map.keySet()) {
                                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
                                bw.write(socket.getRemoteSocketAddress() + "说：" + message.peek() + "\r\n");
                                bw.flush();
                            }
                            message.poll();// 移除对头信息
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
