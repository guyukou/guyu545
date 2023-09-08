package com.example.springboot.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author guyu06
 * @date 2023/8/15 11:43
 */
@ConditionalOnExpression("'${WCloud_Env}' == 'Stable' || '${WCloud_Env}' == 'Test'")
@Slf4j
@Service
public class ConditionalBean {
    @PostConstruct
    public void init() {
        System.err.println("ConditionalBean inited");
    }
}
