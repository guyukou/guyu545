package com.guyu.lambda;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author guyu06
 * @date 2023/4/9 23:06
 */
public class OptionalFlatMapMethodTest {

    private static class Entity {

    }

    @Test
    public void test_flatMap() {

        // 有值的情况
        var inner = Optional.of("garry");
        var outer = Optional.of(inner);
        var s1 = outer.flatMap(s -> s)
                .orElse(null);
        assertEquals("garry", s1);



        // 无值的情况
        inner = Optional.empty();
        outer = Optional.of(inner);
        s1 = outer.flatMap(s -> s)
                .orElse(null);
        assertNull(s1);
    }
}
