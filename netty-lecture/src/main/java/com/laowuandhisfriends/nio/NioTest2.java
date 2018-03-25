package com.laowuandhisfriends.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("src/main/java/com/laowuandhisfriends/nio/NioTest2.txt");
        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);
        System.out.println(byteBuffer);

        byteBuffer.flip();

        System.out.println(byteBuffer);


        while (byteBuffer.hasRemaining()) {
            System.out.println("Character: " + (char) (byteBuffer.get()));
        }

        fis.close();
    }
}
