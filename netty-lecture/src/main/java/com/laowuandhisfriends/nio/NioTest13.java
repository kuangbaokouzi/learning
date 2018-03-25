package com.laowuandhisfriends.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest13 {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/java/com/laowuandhisfriends/nio/NioTest13_in.txt";
        String outputFile = "src/main/java/com/laowuandhisfriends/nio/NioTest13_out.txt";

        RandomAccessFile input = new RandomAccessFile(inputFile, "r");
        RandomAccessFile output = new RandomAccessFile(outputFile, "rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputChannel = input.getChannel();
        FileChannel outputChannel = output.getChannel();

        MappedByteBuffer mappedByteBuffer = inputChannel.map(FileChannel.MapMode.READ_ONLY,
                0, inputLength);

        Charset charset = Charset.forName("iso-8859-1");
        // string to char array
        CharsetDecoder decoder = charset.newDecoder();
        // char array to string
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(mappedByteBuffer);
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        outputChannel.write(byteBuffer);
        input.close();
        output.close();
    }
}
