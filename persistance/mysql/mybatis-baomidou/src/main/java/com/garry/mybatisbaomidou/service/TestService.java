package com.garry.mybatisbaomidou.service;

import com.garry.mybatisbaomidou.dos.SupplierLog;
import com.garry.mybatisbaomidou.mapper.SupplierLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guyu06
 * @date 2022/8/25 12:26 上午
 */
@Service
public class TestService {
    private Executor executor = Executors.newCachedThreadPool();

    @Autowired
    private SupplierLogMapper supplierLogMapper;

    @Transactional
    public void teset() {
        SupplierLog supplierLog = new SupplierLog();
        supplierLog.setCallTimes(0);

        supplierLogMapper.insert(supplierLog);

        if (new Random().nextInt() < 1) {
            throw new RuntimeException();
        }
    }
}
