package com.garry.mybatisbaomidou;

import com.garry.mybatisbaomidou.dos.SupplierLog;
import com.garry.mybatisbaomidou.mapper.SupplierLogMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MybatisBaomidouApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SupplierLogMapper supplierLogMapper;

    @Test
    void testCount() {
        String shard = "202203";
        int start = 2;
        int end = 20;
        int count = supplierLogMapper.selectCount(shard, start, end);
        assertEquals(11, count);
    }

    @Test
    void testPage() {
        String shard = "202203";
        int start = 2;
        int end = 20;
        int a = 10;
        int b = 5;
        List<SupplierLog> count = supplierLogMapper.selectPage(shard, start, end, a, b);
        assertEquals(1, count.size());
    }

}
