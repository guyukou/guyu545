package com.garry.multidatasourcemybatisplus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.garry.multidatasourcemybatisplus.mapper.SupplierLogMapper;
import com.garry.multidatasourcemybatisplus.po.SupplierLogPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author guyu06
 * @date 2022/8/25 12:41 上午
 */
@DS("ds2")
@Service
public class SupplierLogService {

    @Autowired
    private SupplierLogMapper supplierLogMapper;

    @Transactional
    public void test() {
        SupplierLogPO supplierLog = new SupplierLogPO();
        supplierLog.setCallTimes(0);

        supplierLogMapper.insert(supplierLog);

        if (new Random().nextInt(10) < 7) {
            throw new RuntimeException();
        }
    }
}
