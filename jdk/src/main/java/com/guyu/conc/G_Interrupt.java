package com.guyu.conc;

import java.util.concurrent.TimeUnit;

/**
 * Thread.currentThread().interrupt()可以设置interrupt status = true
 * @author guyu03
 * Created on 2021-07-07
 */
public class G_Interrupt {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignored) {
        }
        System.err.printf("slept for %d milliseconds.\n",
                System.currentTimeMillis() - start);
    }
}
