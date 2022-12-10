package com.guyu.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guyu06
 * @date 2022/8/9 10:21 上午
 */
public class G_HashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("abc", 11);
        System.out.println(map);
        map.computeIfAbsent("abc", s -> 33);
        System.out.println(map);
    }
}
