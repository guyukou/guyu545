package com.guyu.io;

import com.guyu.util.LazyBoy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class MyClientChannel {
    public static void main(String[] args) throws IOException {
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("localhost", 8888));
//        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//        byteBuffer.put("hello".getBytes());
//        byteBuffer.flip();
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello".getBytes());
        clientChannel.write(byteBuffer);
        byteBuffer.clear();
        clientChannel.read(byteBuffer);
        System.out.println("response: " + new String(byteBuffer.array()));

        LazyBoy.sleepS(10);
    }
}
