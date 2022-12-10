package com.guyu.conc;

import java.util.concurrent.TimeUnit;

/**
 * @author guyu03
 * Created on 2021-07-06
 */
public class G_Wait {

    private synchronized void myWait() throws InterruptedException {
        this.wait();
    }

    public static void main(String[] args) throws Exception{
        G_Wait g_wait = new G_Wait();
        long start = System.currentTimeMillis();
        Thread t = new Thread(() -> {
            try {
                g_wait.myWait();
            } catch (InterruptedException e) {
                System.err.println((System.currentTimeMillis() - start)+"ms后中断了");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
        System.out.println(t.isInterrupted());

    }
}
