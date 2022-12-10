package com.guyu.util;

import java.util.Random;

/**
 * @author guyu06
 * @date 2022/9/21 1:57 PM
 */
public class G_Random {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
