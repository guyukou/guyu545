package com.garry.mybatisbaomidou.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.*;

/**
 * @author guyu06
 * @date 2023/8/7 19:52
 */
@AllArgsConstructor
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女"),
    ;

    @EnumValue
    private final int value;
    private final String name;

}
