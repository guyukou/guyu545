package com.example.springboot.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author guyu06
 * @date 2023/5/22 11:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpireSpecifier {
    private Set<Integer> cityId;
    private Set<Long> companyId;

    private static final ExpireSpecifier DEFAULT_VALUE = new ExpireSpecifier();
    public static ExpireSpecifier defaultValue() {
        return DEFAULT_VALUE;
    }

    public boolean hasValidSpecifier() {
        return !isEmpty(cityId) || !isEmpty(companyId);
    }
    public boolean meetSpecifier(CompanySkuPropertyInfo companySku) {
        return (isEmpty(cityId) || cityId.contains(companySku.getCityId()))
                && (isEmpty(companyId) || companyId.contains(companySku.getCompanyId()));
    }

}