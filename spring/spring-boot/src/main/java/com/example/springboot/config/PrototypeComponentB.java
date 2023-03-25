package com.example.springboot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guyu06
 * @date 2023/1/30 19:41
 */
@Component
@Getter
public class PrototypeComponentB {
    @Autowired
    private PrototypeBean prototypeBean;
}
