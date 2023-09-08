package com.example.springboot.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2023/5/23 10:43
 */
@Slf4j
@Service
public class EnvTest implements CommandLineRunner {
    @Value("${spring.wmb.subject1}")
    private Integer subject1;
    @Value("${spring.wmb.subject2}")
    private Integer subject2;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(subject1);
        System.out.println(subject2);
    }
}
