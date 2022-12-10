package com.guyu.conc;

import com.guyu.util.LazyBoy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptSync {
    public static void main(String[] args) {

        new Thread(() -> {
            lock();
        }).start();
        LazyBoy.sleepS(2);
        Thread t2 = new Thread(() -> {
            lock();
            System.out.println("aa");
        });
        t2.start();
        LazyBoy.sleepS(2);
        t2.interrupt();
    }

    static synchronized void lock2() {
        LazyBoy.sleepS(1000);
    }

    static Lock lock = new ReentrantLock();
    static void lock() {
        lock.lock();
        try {
            LazyBoy.sleepS(1000);
        } finally {
            lock.unlock();
        }
    }
}
