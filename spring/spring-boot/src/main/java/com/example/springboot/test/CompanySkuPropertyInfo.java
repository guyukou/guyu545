package com.example.springboot.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyu06
 * @date 2023/5/22 11:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanySkuPropertyInfo {
    private Integer cityId;
    private Long companyId;
}
