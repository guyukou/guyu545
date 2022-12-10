package com.guyu.conc.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guyu03
 * Created on 2021-07-08
 */
public class G_ReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        ExecutorService es4 = Executors.newSingleThreadExecutor();
        ReentrantLock lock = new ReentrantLock(false);
        es1.execute(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        TimeUnit.SECONDS.sleep(1);
        es2.execute(()->lock.lock());
        TimeUnit.SECONDS.sleep(1);
        es3.execute(()->lock.lock());
        TimeUnit.SECONDS.sleep(1);
        es4.execute(()->lock.lock());

    }
}
