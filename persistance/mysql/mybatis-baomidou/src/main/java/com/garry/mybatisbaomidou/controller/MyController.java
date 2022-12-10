package com.garry.mybatisbaomidou.controller;

import com.garry.mybatisbaomidou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyu06
 * @date 2022/8/25 12:32 上午
 */
@RestController
public class MyController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        testService.teset();
        return "ok";
    }

}
