package com.example.springboot;

import com.example.springboot.config.PrototypeComponentA;
import com.example.springboot.config.PrototypeComponentB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    private PrototypeComponentA a;
    @Autowired
    private PrototypeComponentB b;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(a.getPrototypeBean());
        System.out.println(b.getPrototypeBean());
    }
}