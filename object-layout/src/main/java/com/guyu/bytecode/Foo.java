package com.guyu.bytecode;

/**
 * @author guyu06
 * @date 2022/9/10 9:34 上午
 */
public class Foo {

    static {
        System.out.println("static init");
    }
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java!");
        }
        if (flag == true) {
            System.out.println("Hello, JVM!");
        }
    }
}
