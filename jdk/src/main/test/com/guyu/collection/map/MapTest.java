package com.guyu.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author guyu06
 * @date 2022/11/19 19:33
 */
public class MapTest {

    @Test
    void test() {
        var outMap = new HashMap<Integer, Integer>();
        outMap.put(1, 100);
        outMap.put(2, 200);
        var innerMap = new HashMap<Integer, Integer>();
        innerMap.put(1, 1);
        innerMap.put(3, 3);
        assertEquals(outMap.get(innerMap.get(1)), 100);
        assertNull(outMap.get(innerMap.get(2)));
    }
}
