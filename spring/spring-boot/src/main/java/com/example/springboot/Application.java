package com.example.springboot;

import com.example.springboot.test1.TypeHandler;
import com.example.springboot.test1.set1.EnumA;
import com.example.springboot.test1.set2.EnumB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {


        var values = ctx.getBeansOfType(TypeHandler.class).values();

        resolveHandler(values, EnumA.A1);
        resolveHandler(values, EnumA.A2);
        resolveHandler(values, EnumB.B1);
        resolveHandler(values, EnumB.B2);

    }

    private void resolveHandler(Collection<TypeHandler> handlers, Object obj) {
        handlers.stream()
                .filter(handler -> handler.getType() == obj)
                .findFirst()
                .ifPresent(handler -> {
                    System.out.println(obj + ": " + handler);
                });
    }
}