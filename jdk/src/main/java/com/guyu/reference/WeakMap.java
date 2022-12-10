package com.guyu.reference;

import java.util.WeakHashMap;

public class WeakMap {
    public static void main(String[] args) {
        WeakHashMap<Keyy, String> map = new WeakHashMap<>();
//        ReferenceQueue<WeakReference> queue = new ReferenceQueue<>();
        System.out.println("before put, map.size:"+map.size());
        Keyy key = new Keyy(3);
        map.put(key, "abcd");
        key = null;
        for (int i = 0; i < 10; i++) {
            System.gc();
        }
        System.out.println("after put, map.size:"+map.size());


    }

}
