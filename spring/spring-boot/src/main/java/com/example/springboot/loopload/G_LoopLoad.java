package com.example.springboot.loopload;

import java.lang.reflect.Method;

public class G_LoopLoad {
    public static void main(String[] args) throws Exception {
        while (true) {
            Class<?> protoClass = loadClass(G_LoopLoad.class.getPackage().getName() + "." + "DaSanwangBrokerProcesslogQhyRankDaily");
            Class[] innerClassArr = protoClass.getDeclaredClasses();
            for (Class clazz : innerClassArr) {
                String clazzName = clazz.getSimpleName();
                System.out.println(clazzName);
            }
        }

    }

    private static Class<?> loadClass(String fullClzName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
