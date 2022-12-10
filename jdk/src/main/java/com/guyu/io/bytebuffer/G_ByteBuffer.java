package com.guyu.io.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class G_ByteBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(11);
        System.out.println("initial state");
        printStats(byteBuffer);

        String content = "hello";
        for (byte aByte : content.getBytes()) {
            byteBuffer.put(aByte);
        }
        System.out.println("write 11 bytes.");
        printStats(byteBuffer);


        System.out.println("prepare read");
        byteBuffer.flip();
        printStats(byteBuffer);

        String s = StandardCharsets.UTF_8.decode(byteBuffer).toString();
        System.out.println("read: " + s);
        printStats(byteBuffer);

        System.out.println("for one more read");
        byteBuffer.rewind();
        printStats(byteBuffer);
    }

    private static void printStats(ByteBuffer byteBuffer) {
        System.out.printf("position: %d\n", byteBuffer.position());
        System.out.printf("limit: %d\n", byteBuffer.limit());
        System.out.printf("capacity: %d\n\n", byteBuffer.capacity());
    }
}
