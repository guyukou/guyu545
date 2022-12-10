package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

public class LazyBoy {
    public static void sleepS(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
