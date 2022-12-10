package com.example.springboot.prototype;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author guyu06
 * @date 2022/11/15 14:09
 */
//@Scope(value = PROTOTY
//        proxyMode = ScopedProxyMode.TARGET_CLASS)

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class MyProto {
    private int i = new Random().nextInt(100);

    @Override
    public String toString() {
        return "MyProto{" +
                "i=" + i +
                '}';
    }
}
