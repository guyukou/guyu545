package com.garry.mybatisbaomidou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @author guyu06
 * @date 2022/8/25 12:09 上午
 */
@Configuration
public class DBConfig {

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }
}
