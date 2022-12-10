package com.guyu.exception;

public class StackOF {
    public static void main(String[] args) {
        foo();
    }

    static void foo() {
        int[] a = new int[100];
        foo();
    }
}
