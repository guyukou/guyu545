package com.guyu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class MyDynamicProxy {
    public static void main(String[] args) {
        Map map = (Map) Proxy.newProxyInstance(MyDynamicProxy.class.getClassLoader(), new Class[]{Map.class}, new Handler());

        map.put("a", 1);
        System.out.println(map.get("a"));

    }

    static class Handler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke method name: " + method.getName());
            return null;
        }
    }
}
