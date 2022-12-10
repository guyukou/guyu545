package com.garry.mapstruct.noinject;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

/**
 * @author guyu06
 * @date 2022/11/17 16:27
 */
class NoInjectMainTest {

    @Test
    void test() {
        Long communityId = 12345L;
        var main = new NoInjectMain();
        var beanA = new BeanA(true, "abcd", communityId);
        var beanB = main.startMap(beanA);
        Assertions.assertEquals(beanB, new BeanB(true, "abcd", Set.of(communityId)));
    }

}