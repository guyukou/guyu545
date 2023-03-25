package com.garry.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guyu06
 * @date 2023/2/17 00:05
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class DistinctBeanB {
    private Long identifier;
    private String trueName;
    private List<String> dizhi = new ArrayList<>();
}
