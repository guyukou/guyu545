package com.example.springboot.test1.set2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2023/8/8 19:32
 */
@Slf4j
@Service
public class AbstractServiceBImplTwo extends AbstractServiceB {
    @Override
    public EnumB getType() {
        return EnumB.B2;
    }
}
