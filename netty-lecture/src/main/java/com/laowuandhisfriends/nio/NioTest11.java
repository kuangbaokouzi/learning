package com.laowuandhisfriends.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * scattering or gathering
 */
public class NioTest11 {
    public static void main(String[] args) throws Exception {
        // open a new server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // create an inet socket address and specify the port
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        // bind the server socket channel with a specified InetSocketAddress
        serverSocketChannel.socket().bind(inetSocketAddress);

        int messageLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        // server socket channel accepts a socket channel request and returns it
        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long r = socketChannel.read(buffers);
                bytesRead += r;
                System.out.println("bytesRead: " + bytesRead);
                Arrays.asList(buffers).stream().map(buffer ->
                        "position: " + buffer.position() + ", limit: " + buffer.limit())
                        .forEach(System.out::println);
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.flip();
            });
            long bytesWritten = 0;
            while (bytesWritten < messageLength) {
                long r = socketChannel.write(buffers);
                bytesWritten += r;
            }
            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });
            System.out.println("bytesRead: " + bytesRead
                    + ", bytesWritten: " + bytesWritten + ", messageLength: " + messageLength);
        }
    }
}
