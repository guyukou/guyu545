package com.example.springboot.bean.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author guyu06
 * @date 2023/5/1 12:01
 */
@Slf4j
@Service
@ConditionalOnExpression("${raw.job:false}")
public class ConditionalOnExpressionBean {
    @PostConstruct
    public void init() {
        System.out.println("condition raw.job is true");
    }
}
