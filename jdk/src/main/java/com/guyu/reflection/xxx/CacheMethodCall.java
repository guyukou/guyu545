package com.guyu.reflection.xxx;

import com.google.common.collect.Maps;

import java.util.Set;

/**
 * @author guyu06
 * @date 2023/8/9 15:27
 */
public class CacheMethodCall {
    public static void main(String[] args) {

        var map = Maps.<String, Integer>newHashMap(null);
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        var set = Set.of("a");
        System.out.println(map);
        map.keySet().removeIf(key -> !set.contains(key));
        System.out.println(map);
    }

}
