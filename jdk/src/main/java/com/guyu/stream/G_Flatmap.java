package com.guyu.stream;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author guyu06
 * @date 2022/11/11 10:19
 */
public class G_Flatmap {
    public static void main(String[] args) {
        var doubles = Set.of(1.3, 1.5, 1.6);
        doubles = null;
        List<Integer> collect = Optional.ofNullable(doubles)
                .stream()
                .flatMap(Collection::stream)
                .map(Double::intValue)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
