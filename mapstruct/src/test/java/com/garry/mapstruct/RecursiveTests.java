package com.garry.mapstruct;

import com.garry.mapstruct.incursive.FilterItem;
import com.garry.mapstruct.incursive.FilterSubItem;
import com.garry.mapstruct.incursive.RecursiveMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecursiveTests {
    @Autowired
    private RecursiveMapper recursiveMapper;

    @Test
    public void testRecursive() {
        var source = FilterItem.builder()
                .name("浦东新区")
                .value("1")
                .key("someId")
                .itemsList(List.of(
                        FilterSubItem.builder().name("川沙").value("2").key("sqId").build(),
                        FilterSubItem.builder().name("陆家嘴").value("3").key("sqId").build()
                ))
                .build();
        ;
        var result = recursiveMapper.map(source);
        System.out.println(result);
    }
}
