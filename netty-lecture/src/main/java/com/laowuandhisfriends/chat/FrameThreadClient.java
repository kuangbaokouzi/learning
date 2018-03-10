package com.laowuandhisfriends.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

/**
 * 服务器与客户端之间的交流通过网络输入输出字节流进行的
 */
public class FrameThreadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7878);
        LinkedList<String> messageFromLocal = new LinkedList<>();
        ClientFrame clientFrame = new ClientFrame();
        clientFrame.jButtonEvent(messageFromLocal);
        Thread writeThread = new Thread(new ClientWriteThread(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), messageFromLocal));
        Thread readThread = new Thread(new ClientReadThread(new BufferedReader(new InputStreamReader(socket.getInputStream())), clientFrame));
        writeThread.start();
        readThread.start();
    }
}
