package com.garry.springthreadlocal.controller;

import com.garry.springthreadlocal.tenant.TenantStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyu06
 * @date 2022/9/20 5:42 PM
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoResource {

    @Autowired
    private TenantStore tenantStore;

    @RequestMapping(method = RequestMethod.GET)
    public String getDemo() {
        return String.format("Tenant: %s\n", this.tenantStore.getTenantId());
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
