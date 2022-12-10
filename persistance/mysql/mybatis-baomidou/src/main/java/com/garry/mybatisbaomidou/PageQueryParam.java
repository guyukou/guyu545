package com.garry.mybatisbaomidou;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageQueryParam {
    private String shard;
    private int offset;
    private int limit;
}
