package com.guyu;

import com.guyu.util.LazyBoy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

/**
 * @author guyu06
 * @date 2023/3/2 18:03
 */
public class Main {
    private static final ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue<>(1000);

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                Long offer = null;
                try {
                    offer = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(offer);
            }
        });
        for (int i = 0; i < 10; i++) {
            LazyBoy.sleepS(1);
            queue.add((long) i);
        }
    }
}
