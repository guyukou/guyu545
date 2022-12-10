package com.garry.mapstruct.list;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author guyu06
 * @date 2022/11/18 11:44
 */
class ListServiceTest {
    ListService.TheMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(ListService.TheMapper.class);
    }

    @Test
    void testMap() {
        var beanBList = mapper.map(List.of(new BeanA(false, "hello"), new BeanA(true, "world")));
        assertEquals(beanBList, List.of(new BeanB(false, "hello"), new BeanB(true, "world")));


        assertEquals(mapper.map(new BeanA(false, "hello")), new BeanB(false, "hello"));
    }

}