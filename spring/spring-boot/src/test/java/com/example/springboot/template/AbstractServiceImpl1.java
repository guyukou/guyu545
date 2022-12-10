package com.example.springboot.template;

import org.springframework.stereotype.Component;

/**
 * @author guyu06
 * @date 2022/11/12 22:45
 */
@Component
public class AbstractServiceImpl1 extends AbstractService<String> {
    @Override
    public String getData() {
        return "hello";
    }
}
