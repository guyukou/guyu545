package com.garry.springthreadlocal.tenant;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author guyu06
 * @date 2022/9/20 5:26 PM
 */
@Data
public class TenantStore {
    public TenantStore() {
        System.out.println(1);
    }

    private String tenantId;

    public void clear() {
        Field[] declaredFields = TenantStore.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
//            try {
//                declaredField.set(this, null);
//            } catch (IllegalAccessException ignored) {
//            }
        }
    }

}
