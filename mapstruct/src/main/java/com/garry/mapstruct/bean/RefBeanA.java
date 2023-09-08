package com.garry.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author guyu06
 * @date 2023/8/29 20:54
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class RefBeanA {
    private int i;
    private Map<String, String> map;
}
