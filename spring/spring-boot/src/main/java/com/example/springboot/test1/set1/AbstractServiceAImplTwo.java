package com.example.springboot.test1.set1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2023/8/8 17:54
 */
@Slf4j
@Service
public class AbstractServiceAImplTwo extends AbstractServiceA {
    @Override
    public EnumA getType() {
        return EnumA.A2;
    }
}
