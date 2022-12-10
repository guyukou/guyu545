package com.guyu;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomRateLimiter {
    private int count;
    private TimeUnit timeUnit;

    private long window;
    private int cnt;

    public CustomRateLimiter(int count, TimeUnit timeUnit) {
        this.count = count;
        this.timeUnit = timeUnit;
    }

    public synchronized boolean acquire() {
        long currentWindow = calcWindow();
        if (currentWindow != window) {
            // 更新保存的窗口值
            this.window = currentWindow;
            cnt = 0;
        }
        // 判断是否达到阈值
        if (cnt >= count) {
            return false;
        }
        // 没达到就自增，达到就返回
        cnt++;
        return true;
    }

    private long calcWindow() {
        if (timeUnit == TimeUnit.SECONDS) {
            return System.currentTimeMillis() / 1000;
        } else if (timeUnit == TimeUnit.MINUTES) {
            return System.currentTimeMillis() / 1000 / 60;
        }
        throw new IllegalStateException("不支持的时间单位");
    }

    //    public static void main(String[] args) throws InterruptedException {
//        CustomRateLimiter customRateLimiter = new CustomRateLimiter(10, TimeUnit.SECONDS);
//        for (int i = 0; i < 20; i++) {
//            boolean acquired = customRateLimiter.acquire();
//            System.out.println("第"+i+"次获取成功？:"+acquired);
//        }
//        TimeUnit.SECONDS.sleep(1);
//        for (int i = 0; i < 20; i++) {
//            boolean acquired = customRateLimiter.acquire();
//            System.out.println("第"+i+"次获取成功？:"+acquired);
//        }
//
//    }
}
