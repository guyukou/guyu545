package collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class G_ListSplitter {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(0, 100)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<?> collect1 = Lists.partition(collect, 20).stream()
                .map(l -> {
                    if (l.get(0) > 50) {
                        return new ArrayList<>(l);
                    }
                    return Collections.emptyList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}
