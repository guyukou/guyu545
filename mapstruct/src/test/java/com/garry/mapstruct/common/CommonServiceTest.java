package com.garry.mapstruct.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guyu06
 * @date 2022/11/17 16:37
 */
@SpringBootTest
class CommonServiceTest {
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonMapper commonMapper;
    @Test
    void testNormal() {
        var wrapperB = commonService.startMap(new WrapperA(new InnerA("innerA string"), "wrapperA string"));;
        assertEquals(wrapperB, new WrapperB(true, new InnerB("innerA string"), "wrapperA string"));
    }
    @Test
    void testSourceNull() {
        var wrapperB = commonService.startMap(new WrapperA(null, "wrapperA string"));;
        assertEquals(wrapperB, new WrapperB(true, null, "wrapperA string"));
    }

    @Test
    void testMapToSingle() {
        var result = commonMapper.map(new WrapperA(null, "hello"));
        assertEquals(result, "hello");
    }
}