package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter.SleepingStopwatch;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-10-25
 */
public class T_Ticker {
    public static void main(String[] args) throws InterruptedException {
        SleepingStopwatch systemTimer = SleepingStopwatch.createFromSystemTimer();
        for (int i = 0; i < 10; i++) {
            System.out.println(systemTimer.readMicros());
            LazyBoy.sleepS(1);

        }
    }
}
