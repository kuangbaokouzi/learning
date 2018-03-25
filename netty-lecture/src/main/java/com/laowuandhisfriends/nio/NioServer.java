package com.laowuandhisfriends.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 一个通道负责所有的客户端连接，服务端只有一个线程
 */
public class NioServer {
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel ssChannel = (ServerSocketChannel) selectionKey.channel();
                            client = ssChannel.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                            clientMap.put("[" + UUID.randomUUID() + "]", client);
                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
                            int count = client.read(readBuffer);
                            if (count > 0) {
                                readBuffer.flip();
                                Charset charset = Charset.forName("utf-8");
                                String receivedMessage = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println(client + ": " + receivedMessage);
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (client == entry.getValue()) {
                                        continue;
                                    } else {
                                        ByteBuffer writeBuffer = ByteBuffer.allocateDirect(1024);
                                        writeBuffer.put((entry.getValue() + ": " + receivedMessage).getBytes());

                                        writeBuffer.flip();
                                        entry.getValue().write(writeBuffer);
                                    }
                                }


                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        selectionKeys.remove(selectionKey);
                        // selectionKeys.clear();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
