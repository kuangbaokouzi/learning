package com.laowuandhisfriends.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FrameThreadServer {
    public static Map<Socket, LinkedList> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(7878);
        System.out.println("服务器启动成功，等待客户端...");
        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getRemoteSocketAddress() + " 连接...");
            map.put(socket, new LinkedList<String>());
            Thread readThread = new Thread(new FrameServerReadThread(socket));
            Thread writeThread = new Thread(new FrameServerWriteThread());
            readThread.start();
            writeThread.start();
        }
    }
}
