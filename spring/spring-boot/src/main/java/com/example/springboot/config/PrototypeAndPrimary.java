package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author guyu06
 * @date 2023/1/30 19:40
 */
@Configuration
public class PrototypeAndPrimary {

    @Bean
    @Primary
    @Scope("prototype")
    public PrototypeBean oneProto() {
        return new PrototypeBean();
    }
}
