package com.guyu.reflection;

/**
 * @author guyu06
 * @date 2022/11/12 21:40
 */
public class MethodWithByteArrayArgs {
    public static int foo(byte[] bytes) {
        return bytes.length;
    }

    public static int foo() {
        return 0;
    }
}
