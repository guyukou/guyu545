package com.example.springboot.lifecycle;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author guyu06
 * @date 2023/8/19 15:55
 */
@Slf4j
@Service
public class ShutdownHook implements ApplicationListener<ContextClosedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("begin shutdown hook, ContextClosedEvent");
        Thread.sleep(3000);
        if (new Random().nextInt(10) < 10) {
            throw new Exception("haha");
        }
        log.info("end shutdown hook, ContextClosedEvent");

    }
}
