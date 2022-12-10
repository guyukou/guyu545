package com.guyu.unsafe;

/**
 * @author guyu03
 * Created on 2021-07-08
 */
public class ClassWithExpensiveConstructor {

    private final int value;

    private ClassWithExpensiveConstructor() {
        value = doExpensiveLookup();
    }

    private int doExpensiveLookup() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int getValue() {
        return value;
    }
}
