package com.guyu.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 2022/6/11
 */
@Getter
@AllArgsConstructor
public enum PlatformEnum {
    ant(1,1),
    ;
    private final int code;
    /**
     * 套餐场景平台code
     */
    private final int comboCode;
}
