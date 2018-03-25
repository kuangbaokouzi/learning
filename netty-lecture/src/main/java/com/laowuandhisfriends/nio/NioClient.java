package com.laowuandhisfriends.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws Exception {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));

            while (true) {
                selector.select();
                Set<SelectionKey> selectorKeySet = selector.selectedKeys();
                selectorKeySet.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isConnectable()) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            if (client.isConnectionPending()) {
                                client.finishConnect();
                                ByteBuffer writeBuffer = ByteBuffer.allocateDirect(1024);
                                writeBuffer.put((LocalDateTime.now() + "connected successfully!").getBytes());
                                writeBuffer.flip();
                                client.write(writeBuffer);

                                ExecutorService executorService =
                                        Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(() -> {
                                    while (true) {
                                        try {
                                            writeBuffer.clear();

                                            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                            System.out.println("please input: ");
                                            String sendMessage = bufferedReader.readLine();

                                            writeBuffer.put(sendMessage.getBytes());
                                            writeBuffer.flip();
                                            client.write(writeBuffer);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            client.register(selector, SelectionKey.OP_READ);
                        } else if (selectionKey.isReadable()) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
                            int count = client.read(readBuffer);
                            if (count > 0) {
                                String receivedMessage = new String(readBuffer.array(), 0, count);
                                System.out.println("receivedMessage: " + receivedMessage);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        selectorKeySet.remove(selectionKey);
                    }
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
