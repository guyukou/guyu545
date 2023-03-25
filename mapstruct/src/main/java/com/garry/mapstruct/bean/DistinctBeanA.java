package com.garry.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guyu06
 * @date 2023/2/17 00:05
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class DistinctBeanA {
    private Long id;
    private String name;
    private List<String> address;
}
