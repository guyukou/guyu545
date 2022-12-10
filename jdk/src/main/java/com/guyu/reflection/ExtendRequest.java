package com.guyu.reflection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guyu06
 * @date 2022/11/14 15:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExtendRequest {
    private boolean img;
    private boolean video;
    private boolean pano;


    public static final List<Field> declaredFields;

    static {
        declaredFields = Arrays.stream(ExtendRequest.class.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toList());
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
        }
    }

    public static ExtendRequest includeAll() {
        ExtendRequest request = new ExtendRequest();
        for (Field field : declaredFields) {
            try {
                field.setBoolean(request, true);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return request;
    }
}
