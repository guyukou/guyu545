package com.garry.mapstruct.mapper;

import com.garry.mapstruct.bean.AddDateBeanA;
import com.garry.mapstruct.bean.AddDateBeanB;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author guyu06
 * @date 2023/6/6 17:20
 */
public class AddDateFieldMapperTest {
    private static AddDateFieldMapper mapper;

    @BeforeAll
    static void init() {
        mapper = Mappers.getMapper(AddDateFieldMapper.class);
    }
    @Test
    void test() {
        var build = AddDateBeanB.builder()
                .addDate(100L)
                .postDate(100L)
                .build();
        var addDateBeanA = mapper.toA(build);
        System.out.println(addDateBeanA);
    }
}
