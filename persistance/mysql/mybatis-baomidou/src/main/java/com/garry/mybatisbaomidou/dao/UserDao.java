package com.garry.mybatisbaomidou.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garry.mybatisbaomidou.mapper.UserMapper;
import com.garry.mybatisbaomidou.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2023/4/4 22:50
 */
@Slf4j
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {

    public User getUser(long id) {
        return baseMapper.mysql(id);
    }

}
