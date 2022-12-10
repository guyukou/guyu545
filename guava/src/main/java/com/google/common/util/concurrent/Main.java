package com.google.common.util.concurrent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-10-31
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String s = "abc";
        Map<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.containsKey(c)) {
            }
        }
    }
}
