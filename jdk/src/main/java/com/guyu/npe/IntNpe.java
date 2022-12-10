package com.guyu.npe;

import java.util.Objects;

public class IntNpe {
    public static void main(String[] args) {
        int i = 0;
        Integer j = null;
        test2(i, j);
        test(i, j);
    }

    static void test(int i, Integer j) {
        if (i != j) {
            System.out.println("i != j");
        }
    }

    static void test2(int i, Integer j) {
        if (!Objects.equals(i, j)) {
            System.out.println("i != j");
        }
    }



}
