package com.guyu.lambda.collect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author guyu06
 * @date 2022/11/15 20:26
 */
public class GroupBy {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StatsCardItem {
        private String key;
        private Integer value;
    }

    @Test
    void testGroupBy() {
        List<StatsCardItem> list = List.of(
                new StatsCardItem("a", 1),
                new StatsCardItem("a", 2),
                new StatsCardItem("a", 3),
                new StatsCardItem("b", 1),
                new StatsCardItem("b", 2));
        var collect = list.stream()
                .collect(Collectors.groupingBy(StatsCardItem::getKey, Collectors.mapping(StatsCardItem::getValue, Collectors.toSet())));
        Assertions.assertEquals(collect, Map.of("a", Set.of(1,2,3), "b", Set.of(1,2)));
    }
}
