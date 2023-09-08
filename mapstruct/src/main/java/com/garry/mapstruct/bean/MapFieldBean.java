package com.garry.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author guyu06
 * @date 2023/8/9 14:29
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MapFieldBean {
    private Map<String, String> params;
    private Integer age;
}
