package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2022/9/21 11:18 AM
 */
@Primary
@Service
public class MyServiceProxy extends MyService {
    @Autowired
    @Qualifier("myService")
    private MyService myService;
}
