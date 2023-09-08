package com.garry.wlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guyu06
 * @date 2023/5/24 10:13
 */
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    private void test() {
        var executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    this.test2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void test2() throws InterruptedException {
        synchronized (this) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("test2");
        }
    }

}
