package com.guyu.unsafe;

/**
 * @author guyu03
 * Created on 2021-07-08
 */
public class ClassWithMultipleFields {
    private int i;
    private double d;
    private boolean b;
    private String s;
    private ClassWithMultipleFields self;

    public int getI() {
        return i;
    }
}
