package com.guyu.conc.synchronize;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class G_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("done");


    }
}
