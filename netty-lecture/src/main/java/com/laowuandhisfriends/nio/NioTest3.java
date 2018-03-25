package com.laowuandhisfriends.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("src/main/java/com/laowuandhisfriends/nio/NioTest3.txt");
        FileChannel fileChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] messages = "hello world welcome, nihao".getBytes();

        for (byte by : messages) {
            byteBuffer.put(by);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fos.flush();
        fos.close();
    }
}
