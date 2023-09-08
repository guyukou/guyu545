package com.example.springboot.bean.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author guyu06
 * @date 2023/5/1 12:11
 */
@Slf4j
@Service
@ConditionalOnProperty("myproperty")
public class ConditionalOnPropertyBean {
    @PostConstruct
    public void init() {
        System.out.println("myproperty is set.");
    }
}
