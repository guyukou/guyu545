package com.guyu.math;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2022/6/11
 */
public class ComboDto {
    private int code;
    public boolean on(PlatformEnum platform) {
        return (platform.getComboCode() & code) != 0;
    }

    public ComboDto(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        List<Integer> codes = Arrays.asList(1, 2, 3);
        for (Integer code : codes) {
            ComboDto dto = new ComboDto(code);
            for (PlatformEnum platform : PlatformEnum.values()) {
                System.out.printf("code: %d on %s: %b\n", code, platform, dto.on(platform));
            }
        }


    }
}
