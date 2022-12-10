package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author guyu06
 * @date 2022/8/21 5:28 下午
 */
@Service
public class MyService {
    @Autowired
    private SubService subService;

    @PostConstruct
    public void init() {
        dosth();
    }

    public void dosth() {
        subService.dd();
    }

    @Service
    private static class SubService {
        public void dd() {
        }
    }
}
