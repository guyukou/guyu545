package com.garry.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyu06
 * @date 2022/11/17 16:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeanA {
    private boolean show;
    private String str;
    private Long communityId;

    public BeanA(boolean show, String str) {
        this(show, str, null);
    }
}
