package com.laowuandhisfriends.zerocopy;

import java.io.*;
import java.net.Socket;

public class OldClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);
        String fileName = "/home/kouzikaile/下载/ideaIU-2017.3.4.tar.1.gz";

        InputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(bytes)) != -1) {
            total += readCount;
            dataOutputStream.write(bytes, 0, (int) readCount);
        }
        System.out.println("total: " + total + ", time: " + (System.currentTimeMillis() - startTime));
    }
}
