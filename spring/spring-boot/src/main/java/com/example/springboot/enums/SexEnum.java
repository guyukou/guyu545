package com.example.springboot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum SexEnum {
    MALE(1, "男人"),
    FEMALE(2, "女人"),
    ;
    private final int code;
    private final String desc;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SexEnum from(String code) {
        return Arrays.stream(values())
                .filter(sex -> sex.code == Integer.parseInt(code))
                .findFirst()
                .orElse(null);
    }
}
