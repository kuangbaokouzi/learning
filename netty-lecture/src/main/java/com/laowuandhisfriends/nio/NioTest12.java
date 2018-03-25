package com.laowuandhisfriends.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        // open a new selector
        Selector selector = Selector.open();
        for (int port : ports) {
            // open a new server socket channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // set unblocking server socket channel
            serverSocketChannel.configureBlocking(false);

            // get the server socket of the server socket channel
            ServerSocket serverSocket = serverSocketChannel.socket();
            // new a port
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            // bind a new port
            serverSocket.bind(inetSocketAddress);

            // register the server socket channel into the selector, and set the selection key to OP_ACCEPT
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口: " + port);
        }

        while (true) {
            // select a set of keys whose corresponding channels are ready for I/O operations.
            // return the number of keys.
            int num = selector.select();
            System.out.println("numbers: " + num);

            // return the selected-keys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys: " + selectionKeys);
            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey selectionKey = iter.next();
                if (selectionKey.isAcceptable()) {// ready for a new socket connection
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);

                    iter.remove();

                    System.out.println("获得客户端链接: " + socketChannel);
                } else if (selectionKey.isReadable()) {// ready for operation
                    // select the selected-key corresponding channel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    int bytesRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        bytesRead += read;
                    }
                    System.out.println("读取: " + bytesRead + ", 来自于: " + socketChannel);
                    iter.remove();
                }
            }
        }
    }
}
