package collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class G_MapSplitter {
    public static void main(String[] args) {
        List<Long> collect = LongStream.range(0, 300)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(batchCheckIsJoinStore(new HashSet<>(collect)));

    }
    public static Map<Long, Boolean> batchCheckIsJoinStore(Set<Long> crmStoreIds) {
        return Lists.partition(new ArrayList<>(crmStoreIds), 10).stream()
                .map(G_MapSplitter::doBatchCheckIsJoinStore)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map<Long, Boolean> doBatchCheckIsJoinStore(List<Long> storeIds) {
        return storeIds.stream()
                .collect(Collectors.toMap(Function.identity(), id -> id % 2 == 0));
    }


}
