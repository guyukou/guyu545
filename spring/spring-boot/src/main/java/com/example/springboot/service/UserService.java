package com.example.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author guyu06
 * @date 2023/4/26 10:27
 */
@Slf4j
@Service
@Lazy
public class UserService {
    @PostConstruct
    public void init() {
        System.out.println("UserService init.");
    }
}
