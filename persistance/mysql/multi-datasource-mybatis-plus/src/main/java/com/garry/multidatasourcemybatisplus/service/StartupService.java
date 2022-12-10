package com.garry.multidatasourcemybatisplus.service;

import com.garry.multidatasourcemybatisplus.mapper.TriPositionMapper;
import com.garry.multidatasourcemybatisplus.mapper.TriRoleMapper;
import com.garry.multidatasourcemybatisplus.po.TriRolePO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author guyu06
 * @date 2022/8/24 11:59 下午
 */
@Slf4j
@Service
public class StartupService {

    @Autowired
    private TriRoleMapper triRoleMapper;
    @Autowired
    private TriPositionMapper triPositionMapper;

    @Transactional(rollbackFor = Exception.class)
    public void doInsert() {
        TriRolePO triRolePO = new TriRolePO();
        triRolePO.setName("店长");
        triRoleMapper.insert(triRolePO);
        if (new Random().nextInt(10) < 7) {
            throw new RuntimeException();
        }
    }

}
