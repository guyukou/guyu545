package org.guyu.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-09-20
 */
public class T_RateLimiter {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            System.out.println(rateLimiter.acquire(1));
        }
    }
}
