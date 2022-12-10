package com.garry.mapstruct.innermapper;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author guyu06
 * @date 2022/11/17 16:16
 */
@SpringBootTest
class InnerMapperServiceTest {
    @Autowired
    private InnerMapperService innerMapperService;


    @Test
    void test() {
        var beanA = new BeanA(true, "abcd");
        var beanB = innerMapperService.startMap(beanA);
        Assertions.assertEquals(beanB, new BeanB(true, "abcd"));
    }

}