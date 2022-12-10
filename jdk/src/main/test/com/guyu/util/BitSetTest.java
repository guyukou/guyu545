package com.guyu.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author guyu06
 * @date 2022/9/30 11:13 AM
 */
public class BitSetTest {

    @Test
    void testEmptyBitSet() {
        BitSet bitSet = new BitSet();
        IntStream.rangeClosed(0, 100)
                .forEach(i -> assertFalse(bitSet.get(i)));
    }


    @Test
    void test() {
        int start = 0;
        int end = 99;
        List<Integer> bits = Arrays.asList(0, 1, 3, 5, 7, 9, 15, 20, 50, 90, 98, 99);
        BitSet bitSet = new BitSet();
        bits.forEach(bitSet::set);
        for (int i = start; i <= end; i++) {
            if (bits.contains(i)) {
                assertTrue(bitSet.get(i));
            } else {
                assertFalse(bitSet.get(i));
            }
        }
    }
}
