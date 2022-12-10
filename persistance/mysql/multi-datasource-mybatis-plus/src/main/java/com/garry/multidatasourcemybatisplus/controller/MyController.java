package com.garry.multidatasourcemybatisplus.controller;

import com.garry.multidatasourcemybatisplus.service.StartupService;
import com.garry.multidatasourcemybatisplus.service.SupplierLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyu06
 * @date 2022/8/25 12:35 上午
 */
@RestController
public class MyController {

    @Autowired
    private StartupService service;
    @Autowired
    private SupplierLogService supplierLogService;

    @GetMapping("/hello")
    public String hello() {
        service.doInsert();
        return "hello";
    }

    @GetMapping("/world")
    public String world() {
        supplierLogService.test();
        return "ok";
    }
}
