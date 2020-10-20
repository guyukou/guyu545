package org.guyu.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-09-20
 */
public class T_RateLimiter {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(0.5);
        while (true) {
            double acquire = rateLimiter.acquire();
            System.out.println(acquire);
        }
    }
}
