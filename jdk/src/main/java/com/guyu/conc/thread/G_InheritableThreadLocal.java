package com.guyu.conc.thread;

public class G_InheritableThreadLocal {
    private static InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        Thread pThread = Thread.currentThread();
        itl.set("guyu");
        System.out.println(itl.get());
        Thread cThread = new Thread(() -> {
            System.out.println(itl.get());
        });
        cThread.start();
        System.out.println();
    }
}
