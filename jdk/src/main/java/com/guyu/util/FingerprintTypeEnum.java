package com.guyu.util;


import lombok.Getter;

@Getter
public enum FingerprintTypeEnum {
    NONE(0, "未知类型"),
    HOUSE_ID(1, "房号ID"),
    HOUSE_TYPE(2, "磐石户型"),
    HOUSE_TEXT(4, "文本房号"),

    ;
    /**
     * type id
     */
    final int value;

    /**
     * 状态说明
     */
    final String name;

    FingerprintTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

}
