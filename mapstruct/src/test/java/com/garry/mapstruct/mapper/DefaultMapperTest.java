package com.garry.mapstruct.mapper;

import com.garry.mapstruct.bean.DistinctBeanA;
import com.garry.mapstruct.bean.DistinctBeanB;
import com.garry.mapstruct.bean.SameBeanA;
import com.garry.mapstruct.bean.SameBeanB;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Comparator;
import java.util.List;

/**
 * @author guyu06
 * @date 2023/2/17 00:11
 */
class DefaultMapperTest {
    private static DefaultMapper defaultMapper;

    @BeforeAll
    static void init() {
        defaultMapper = Mappers.getMapper(DefaultMapper.class);
    }

    @Test
    void testMapSingleOfSame() {
        Long id = 545L;
        String name = "garry";
        var sameBeanA = SameBeanA.builder()
                .id(id)
                .name(name)
                .build();
        var sameBeanB = SameBeanB.builder()
                .id(id)
                .name(name)
                .build();
        Assertions.assertEquals(sameBeanA, defaultMapper.mapSingleOfSame(sameBeanB));
    }

    @Test
    void testMapListOfSame() {
        Long id = 545L;
        String name = "garry";
        Long id2 = 945L;
        String name2 = "gates";
        var sameBeanAList = List.of(SameBeanA.builder().id(id).name(name).build(), SameBeanA.builder().id(id2).name(name2).build());
        var sameBeanBList = List.of(SameBeanB.builder().id(id).name(name).build(), SameBeanB.builder().id(id2).name(name2).build());
        Assertions.assertEquals(sameBeanAList, defaultMapper.mapListOfSame(sameBeanBList));
    }

    @Test
    public void te() {
        var aLong = List.of(3L, 5L, 11L)
                .stream()
                .max(Comparator.comparingLong(i -> i * i))
                .orElse(null);
        Assertions.assertEquals(11,aLong);
    }

    @Test
    public void testMapSingleOfDistinct() {
        Long id = 545L;
        String name = "garry";
        var distinctBeanA = DistinctBeanA.builder()
                .id(id)
                .name(name)
                .address(Lists.newArrayList())
                .build();
        var distinctBeanB = DistinctBeanB.builder()
                .identifier(id)
                .trueName(name)
                .dizhi(null)
                .build();
        Assertions.assertEquals(distinctBeanA, defaultMapper.mapSingleOfDistinct(distinctBeanB));
    }
}