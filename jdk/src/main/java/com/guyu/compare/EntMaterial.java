package com.guyu.compare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyu06
 * @date 2023/5/24 16:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntMaterial {
    private boolean hasClaim;
    private boolean hasClaimAndOnline;
    private long updateTime;
}
