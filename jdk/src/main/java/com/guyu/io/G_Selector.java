package com.guyu.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_READ;

/**
 * 参考https://www.baeldung.com/java-nio-selector
 */
public class G_Selector {
    public static void main(String[] args) {
//        normalWay();
        nettyWay();
    }

    private static void normalWay() {
        try {
            ServerSocketChannel serverSock = ServerSocketChannel.open();
            serverSock.configureBlocking(false);
            serverSock.bind(new InetSocketAddress(8888));
            Selector selector = Selector.open();
            serverSock.register(selector, OP_ACCEPT);
            while (true) {
                selector.select(); // 阻塞模式
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator(); // selector.selectedKeys()返回的key需要手动移除
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    if ((selectionKey.interestOps() & OP_ACCEPT) != 0) {
                        System.out.println("收到连接事件");
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, OP_READ);
                    }
                    if ((selectionKey.interestOps() & OP_READ) != 0) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        client.read(byteBuffer);
                        if (new String(byteBuffer.array()).trim().length() == 0) {
                            client.close();
                            System.out.println("Not accepting client messages anymore");
                        } else {
                            System.out.println("收到读事件");
                            byteBuffer.flip();
                            System.out.println(StandardCharsets.UTF_8.decode(byteBuffer));
                            byteBuffer.flip();
                            client.write(byteBuffer);
                            byteBuffer.clear();
                        }
                    }
                    iterator.remove(); // 手动移除key，否则下次调用还有
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nettyWay() {
        try {
            ServerSocketChannel serverSock = ServerSocketChannel.open();
            serverSock.configureBlocking(false);
            Selector selector = Selector.open();
            serverSock.register(selector, 0);
            serverSock.bind(new InetSocketAddress(8888));
            serverSock.register(selector, OP_ACCEPT);
            while (true) {
                selector.select(); // 阻塞模式
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator(); // selector.selectedKeys()返回的key需要手动移除
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    if ((selectionKey.interestOps() & OP_ACCEPT) != 0) {
                        System.out.println("收到连接事件");
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, OP_READ);
                    }
                    if ((selectionKey.interestOps() & OP_READ) != 0) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        client.read(byteBuffer);
                        if (new String(byteBuffer.array()).trim().length() == 0) {
                            client.close();
                            System.out.println("Not accepting client messages anymore");
                        } else {
                            System.out.println("收到读事件");
                            byteBuffer.flip();
                            System.out.println(StandardCharsets.UTF_8.decode(byteBuffer));
                            byteBuffer.flip();
                            client.write(byteBuffer);
                            byteBuffer.clear();
                        }
                    }
                    iterator.remove(); // 手动移除key，否则下次调用还有
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
