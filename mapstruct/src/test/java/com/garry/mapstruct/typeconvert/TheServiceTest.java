package com.garry.mapstruct.typeconvert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author guyu06
 * @date 2022/11/19 11:25
 */
class TheServiceTest {
    private final TheMapper theMapper = Mappers.getMapper(TheMapper.class);

    @Test
    void testBoolIntConvert() {

        var beanA = theMapper.toInt(new TheMapper.BeanBool(true, false));
        Assertions.assertEquals(beanA, new TheMapper.BeanInt(1, 0));

        var beanB = theMapper.toBool(new TheMapper.BeanInt(0, 1));
        Assertions.assertEquals(beanB, new TheMapper.BeanBool(false, true));
    }

}