package com.guyu.conc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class G_BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        MyArrBlockingQueue<Integer> queue = new MyArrBlockingQueue<>(3);
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);

//        queue.add(3);
    }

    static class MyArrBlockingQueue<T> {
        private T[] storage;
        private int cnt;
        private int next;
        private int cur;
        private ReentrantLock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private Condition notFull = lock.newCondition();

        public MyArrBlockingQueue(int size) {
            this.storage = (T[]) new Object[size];
        }

        public boolean add(T item) {
            lock.lock();
            try {
                if (cnt == storage.length) {
                    return false;
                }
                storage[next] = item;
                next = (next + 1) % storage.length;
                cnt++;
                notEmpty.signal();
                return true;
            } finally {
                lock.unlock();
            }
        }

        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (cnt == 0) {
                    notEmpty.await();
                }
                cnt--;
                T res = storage[cur];
                cur = (cur + 1) % storage.length;
                return res;
            } finally {
                lock.unlock();
            }
        }
    }
}
