package com.guyu;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class SynchronizedLock {
    public static void main(String[] args) {
        SynchronizedLock synchronizedLock = new SynchronizedLock();
        synchronizedLock.m2();

    }

    /**
     * 启用偏向锁+释放锁
     */
    void m1() {
        log("开始");
        // 0x0000000000000005 (biasable; age: 0)
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        new Thread(()-> {
            synchronized (SynchronizedLock.this) {
                log("获取偏向锁成功");
                // 0x00007fd2a83a4005 (biased: 0x0000001ff4aa0e90; epoch: 0; age: 0)
                System.out.println(ClassLayout.parseInstance(this).toPrintable());
            }
            log("释放锁");
            // 0x00007fd2a83a4005 (biased: 0x0000001ff4aa0e90; epoch: 0; age: 0)
            System.out.println(ClassLayout.parseInstance(this).toPrintable());
            block();
        }).start();

    }

    /**
     * T1获取偏向锁成功后释放，T2获取锁，会是偏向T2，还是轻量锁呢？
     */
    void m2() {
        Thread t1 = new Thread(() -> {
            synchronized (SynchronizedLock.this) {
                log("T1成功获取锁");
                // 0x00007f2758343805 (biased: 0x0000001fc9d60d0e; epoch: 0; age: 0)
                System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
            }
            log("T1释放锁");
            // 0x00007f2758343805 (biased: 0x0000001fc9d60d0e; epoch: 0; age: 0)
            System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (SynchronizedLock.this) {
                log("T2成功获取锁");
                // 0x00007f2748a978e8 (thin lock: 0x00007f2748a978e8)
                System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
            }
            log("T2释放锁");
            // 0x0000000000000001 (non-biasable; age: 0)
            System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
        });
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    /**
     * t1| lock:biased                ->unlock
     *       t2|       lock:
     */
    void m3() {

        Thread t1 = new Thread(() -> {
            synchronized (SynchronizedLock.this) {
                log("T1成功获取锁");
                System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
                nap(10);
            }
//            log("T1释放锁");
//            System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (SynchronizedLock.this) {
                log("T2成功获取锁");
                System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());

            }
            log("T2释放锁");
            System.out.println(ClassLayout.parseInstance(SynchronizedLock.this).toPrintable());
        });
        t2.start();
    }
    static void log(String msg) {
        System.out.println(msg);
        nap();
    }

    static void nap() {
        nap(300);
    }
    static void nap(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void block() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
