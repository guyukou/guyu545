package com.guyu.lambda.collect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guyu06
 * @date 2022/11/13 18:12
 */
public class ToMapTest {
    @Test
    void testToMap() {

        Executable e = () -> {
            Stream.of(1, 2, 3)
                    .collect(Collectors.toMap(Function.identity(), id -> {
                        if (id < 2) {
                            return null;
                        }
                        return id * id;
                    }));
        };
        Assertions.assertThrowsExactly(NullPointerException.class, e);
    }
}
