package com.example.springboot.test;

import com.anjuke.property.util.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author guyu06
 * @date 2023/5/22 11:13
 */
class ExpireSpecifierTest {

    @Test
    void meetSpecifier() {
        var s = "";
        var expireSpecifier = getExpireSpecifier(s);

        Assertions.assertFalse(expireSpecifier.hasValidSpecifier());

        expireSpecifier = getExpireSpecifier("{\"cityId\":[1],\"companyId\":[100]}");
        Assertions.assertTrue(expireSpecifier.hasValidSpecifier());
        Assertions.assertTrue(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 100L)));
        Assertions.assertFalse(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 101L)));
        Assertions.assertFalse(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(0, 100L)));


        expireSpecifier = getExpireSpecifier("{\"cityId\":[1],\"companyId\":[]}");
        Assertions.assertTrue(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 100L)));
        Assertions.assertTrue(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 101L)));
        Assertions.assertFalse(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(0, 100L)));

        expireSpecifier = getExpireSpecifier("{\"cityId\":[],\"companyId\":[100]}");
        Assertions.assertTrue(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 100L)));
        Assertions.assertFalse(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(1, 101L)));
        Assertions.assertTrue(expireSpecifier.meetSpecifier(new CompanySkuPropertyInfo(0, 100L)));
    }

    private static ExpireSpecifier getExpireSpecifier(String s) {
        ExpireSpecifier expireSpecifier;
        try {
            expireSpecifier = JsonUtils.fromJSON(s, ExpireSpecifier.class);
        } catch (Exception ignored) {
            expireSpecifier = ExpireSpecifier.defaultValue();
        }
        return expireSpecifier;
    }


}