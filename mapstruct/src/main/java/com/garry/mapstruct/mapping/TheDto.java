package com.garry.mapstruct.mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyu06
 * @date 2022/11/12 20:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheDto {
    private String price;
    private String wanPrice;
}
