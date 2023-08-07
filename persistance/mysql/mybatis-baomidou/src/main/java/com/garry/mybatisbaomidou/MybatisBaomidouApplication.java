package com.garry.mybatisbaomidou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.garry.mybatisbaomidou.mapper")
public class MybatisBaomidouApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBaomidouApplication.class, args);
    }

}
