package com.guyu.math;

import java.math.BigDecimal;

/**
 * @author guyu06
 * @date 2022/8/9 10:04 上午
 */
public class M_BigDecimal {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(123.4);
        BigDecimal b = new BigDecimal(123.3);
        System.out.println(a.compareTo(b));
    }
}
