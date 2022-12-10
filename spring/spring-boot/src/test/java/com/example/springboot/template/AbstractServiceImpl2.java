package com.example.springboot.template;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author guyu06
 * @date 2022/11/12 22:46
 */
@Component
public class AbstractServiceImpl2 extends AbstractService<LocalDate> {
    @Override
    public LocalDate getData() {
        return LocalDate.now();
    }
}
