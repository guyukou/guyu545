package com.guyu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_Stream {
    public static void main(String[] args) {
        testReduce();
    }

    static void testReduce() {
        List<String> strings = Arrays.asList("a", "b");
        System.out.println(strings.stream().reduce((l, r) -> l + " and " + r).get());
        strings = Arrays.asList("b");
        System.out.println(strings.stream().reduce((l, r) -> l + " and " + r).get());
        strings = new ArrayList<>();
        System.out.println(strings.stream().reduce((l, r) -> l + " and " + r).get());
    }
}
