package com.example.springboot;

import com.example.springboot.template.AbstractService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private Map<String, AbstractService> abstractServiceMap;

    @Test
    void contextLoads() {
        abstractServiceMap.values().stream()
                .map(AbstractService::getData)
                .forEach(System.out::println);
    }

}
