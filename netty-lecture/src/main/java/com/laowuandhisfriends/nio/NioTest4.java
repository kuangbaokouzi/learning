package com.laowuandhisfriends.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/laowuandhisfriends/nio/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/laowuandhisfriends/nio/output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        while (true) {
            byteBuffer.clear();
            int read = inputChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }

            byteBuffer.flip();

            outputChannel.write(byteBuffer);
        }
        inputChannel.close();
        outputChannel.close();
    }
}
