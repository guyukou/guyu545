package com.garry.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author guyu06
 * @date 2022/11/17 16:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeanB {
    private boolean showB;
    private String strB;
    private Set<Long> communityIds;

    public BeanB(boolean showB, String strB) {
        this(showB, strB, null);
    }
}
