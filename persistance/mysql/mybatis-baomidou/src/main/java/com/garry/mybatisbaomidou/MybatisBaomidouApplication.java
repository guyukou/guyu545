package com.garry.mybatisbaomidou;

import com.garry.mybatisbaomidou.dos.SupplierLog;
import com.garry.mybatisbaomidou.mapper.SupplierLogMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@MapperScan
@SpringBootApplication
@EnableTransactionManagement
public class MybatisBaomidouApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBaomidouApplication.class, args);
    }

    @Autowired
    private SupplierLogMapper supplierLogMapper;

    @Override
    public void run(String... args) throws Exception {

//        ShardPageQuery<SupplierLog> shardPageQuery = ShardPageQuery.builder(
//                (param) -> supplierLogMapper.selectPage(param.getShard(), 2, 20, param.getOffset(), param.getLimit()))
//                .countFunc((shard) -> supplierLogMapper.selectCount(shard, 2, 20))
//                .shards(Arrays.asList("202202", "202203", "202204"))
//                .pageNum(2)
//                .pageSize(14)
//                .build();
//
//        Page<SupplierLog> supplierLogPage = shardPageQuery.doQuery();
//        System.out.println(supplierLogPage);
    }
}
