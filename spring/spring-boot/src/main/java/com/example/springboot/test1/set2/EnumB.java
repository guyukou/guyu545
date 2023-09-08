package com.example.springboot.test1.set2;

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
public enum EnumB implements HasIntValue {
    B1(1, "B1"),
    B2(2, "B2"),

    ;


    private final int value;
    private final String name;

    @Nullable
    public static EnumB from(Integer value) {
        return EnumUtils.from(value, EnumB.class);
    }
}


