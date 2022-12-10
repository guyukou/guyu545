package com.guyu.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import static com.guyu.util.LazyBoy.sleepS;


/**
 * 一个对象变成Weakly Reachable时（以下简称WRO）：
 *
 * 1. 引用它的WeakReference把引用置为null
 * 2. WRO将被GC
 * 3. WeakReference被放进ReferenceQueue中（前提是如果构造WeakReference时用了ReferenceQueue）
 */
public class WeakRef {
    public static void main(String[] args) {

    }

    private static void enqueue_as_weakly_reachable() {
        Keyy key = new Keyy(22);
        ReferenceQueue<Keyy> queue = new ReferenceQueue<>();
        WeakReference<Keyy> weakRef = new WeakReference<Keyy>(key, queue);
        System.out.println("at start, queue size is: "+ queue.poll());

        System.gc();
        System.out.println("after gc, queue size is: "+ queue.poll());

        key = null;
        System.gc();
        System.out.println("when weakly reachable, queue size is: "+ queue.poll());
    }

    private static void collect_as_weakly_reachable() {
        Keyy key = new Keyy(22);
        WeakReference<Keyy> weakRef = new WeakReference<>(key);
        printReferent("at start, value is: ", weakRef);

        System.gc();
        printReferent("after gc, value is: ", weakRef);

        key = null;
        System.gc();
        printReferent("when weakly reachable, value is: ", weakRef);
    }

    static void printReferent(String intro, WeakReference<Keyy> weakReference) {
        System.out.println(intro + weakReference.get());
    }
}
