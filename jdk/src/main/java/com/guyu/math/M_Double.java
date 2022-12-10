package com.guyu.math;

import java.math.BigDecimal;

public class M_Double {
    public static void main(String[] args) {
        double price = 1.23d * 31200 * 3;
        System.out.println(a(price));
        System.out.println(b(price));
        System.out.println(c(price));
    }

    private static String a(double price) {
        return new BigDecimal(price).divide(BigDecimal.valueOf(1000000d), 2, BigDecimal.ROUND_HALF_UP).toString();
    }

    private static String b(double price) {
        return String.valueOf(price/1000000);
    }
    private static String c(double price) {
        return new BigDecimal(price / 1000000).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
