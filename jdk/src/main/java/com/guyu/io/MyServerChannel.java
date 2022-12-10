package com.guyu.io;

import com.guyu.util.LazyBoy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyServerChannel {
    public static void main(String[] args) {
        try {
            LazyBoy.sleepS(5);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8088));
            serverSocketChannel.configureBlocking(false);
            SocketChannel aChannel;
            while (true) {
                aChannel = serverSocketChannel.accept();
                if (aChannel == null) {
                    System.out.println("no incoming conn, sleep for 1s and retry...");
                    LazyBoy.sleepS(1);
                    continue;
                }
                break;
            }
            System.out.println("accept a channel " + aChannel);
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            aChannel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print(new String(new byte[]{byteBuffer.get()}));
            }
            byteBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
