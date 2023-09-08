package com.example.springboot.test1.set1;

import com.anjuke.property.util.enums.EnumUtils;
import com.anjuke.property.util.enums.HasIntValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nullable;

/**
 * @author guyu06
 * @date 2023/8/8 17:50
 */


@Getter
@RequiredArgsConstructor
public enum EnumA implements HasIntValue {
    A1(1, "A1"),
    A2(2, "A2"),

    ;


    private final int value;
    private final String name;

    @Nullable
    public static EnumA from(Integer value) {
        return EnumUtils.from(value, EnumA.class);
    }
}


