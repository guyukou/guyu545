package com.garry.mapstruct.incursive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guyu06
 * @date 2022/11/15 23:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterSubItem {
    private String name;
    private String key;
    private String value;
}
