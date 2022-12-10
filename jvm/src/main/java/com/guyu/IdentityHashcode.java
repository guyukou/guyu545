package com.guyu;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class IdentityHashcode {
    public static void main(String[] args) {
        IdentityHashcode identityHashcode = new IdentityHashcode();
        identityHashcode.printHeaderDuringLockUpgrade();

    }

    void printHeaderDuringLockUpgrade() {
//        1. 初始状态
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
//        2. 缓存hashcode
        System.out.println(this.hashCode());
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
