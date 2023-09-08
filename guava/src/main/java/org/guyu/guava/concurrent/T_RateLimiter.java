package org.guyu.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-09-20
 */
public class T_RateLimiter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);
        RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 1000; i++) {
            rateLimiter.acquire();
            if (i % 10 == 0) {
                rateLimiter.setRate(rateLimiter.getRate() * 2);
            }
            es.execute(() -> {
                System.out.println(new Date());
            });
        }



    }
}
