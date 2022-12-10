package com.garry.multidatasourcemybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.garry.multidatasourcemybatisplus.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class MultiDatasourceMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceMybatisPlusApplication.class, args);
    }

}
