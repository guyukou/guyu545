package com.garry.springinterceptor.controller;

import com.garry.springinterceptor.interceptor.annotation.ValidationAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyu06
 * @date 2023/1/3 14:49
 */
@RestController
public class MyController {

    @ValidationAnnotation
    @GetMapping("/interceptor/test")
    public String test() {
        return "ok";
    }

    @GetMapping("/interceptor/test2")
    public String test2() {
        return "ok";
    }
}
