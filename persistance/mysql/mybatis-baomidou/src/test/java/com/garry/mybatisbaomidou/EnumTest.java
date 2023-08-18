package com.garry.mybatisbaomidou;

import com.garry.mybatisbaomidou.dao.UserDao;
import com.garry.mybatisbaomidou.enums.SexEnum;
import com.garry.mybatisbaomidou.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author guyu06
 * @date 2023/8/7 19:50
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void xxx() {
        userDao.saveBatch(List.of(
                new User(null, SexEnum.FEMALE, "garry", 1, 1, ""),
                new User(null, SexEnum.MALE, "lily", 1, 1, "")
        ));
        var u2 = userDao.getById(2L);
        u2.setSex(SexEnum.FEMALE);
        userDao.saveOrUpdate(u2);
        Assertions.assertEquals(userDao.getById(2L).getSex(), SexEnum.FEMALE);
    }
}
