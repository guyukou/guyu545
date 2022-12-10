package com.guyu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author guyu06
 * @date 2022/11/14 15:54
 */
public class FieldCacheTest {

    @Test
    void testFieldCache() {
        List<Field> collect = ExtendRequest.declaredFields;
        ExtendRequest extendRequest = ExtendRequest.includeAll();

        for (Field declaredField : collect) {
            System.out.println(declaredField.canAccess(extendRequest));
        }

        ExtendRequest extendRequest1 = new ExtendRequest();
        for (Field declaredField : collect) {
            System.out.println(declaredField.canAccess(extendRequest1));
        }
    }
}
