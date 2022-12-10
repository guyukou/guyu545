package com.guyu.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guyu06
 * @date 2022/11/12 21:40
 */
public class ReflectionTest {
    @Test
    void testGetMethodWithByteArrayArgs() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method foo = MethodWithByteArrayArgs.class.getMethod("foo");
        assertEquals(foo.invoke(null), 0);

        Class<?>[] parameterTypes = {byte[].class};
        foo = MethodWithByteArrayArgs.class.getMethod("foo", parameterTypes);
        assertEquals(foo.invoke(null, new byte[]{1,2,3,4,5}), 5);
    }
}
