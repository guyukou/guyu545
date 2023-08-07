package com.garry.mybatisbaomidou;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.garry.mybatisbaomidou.user.User;
import com.garry.mybatisbaomidou.dao.UserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author guyu06
 * @date 2023/4/4 22:14
 */
@SpringBootTest
public class SqlTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    public void init() {
        userDao.save(new User(6L, "garry", 30, "guyu545kou@gmail.com"));
    }


    @Test
    public void test_UpdatePart() {
        var toUpdateValue = new User(null,"garry",null,"invalidEmail");
        var lambdaUpdateWrapper = new LambdaUpdateWrapper<User>()
                .eq(User::getEmail, "guyu545kou@gmail.com")
                ;

        var updateSuccess = userDao.update(toUpdateValue, lambdaUpdateWrapper);
        Assertions.assertTrue(updateSuccess);

        var me = userDao.getById(6L);
        // 对比更新前，只更新了email字段
        Assertions.assertEquals(new User(6L, "garry", 30, "invalidEmail"), me);

        updateSuccess = userDao.update(
                new LambdaUpdateWrapper<User>()
                        .eq(User::getName, "garry")
                        .set(User::getEmail, "invalidEmail2")
        );
        Assertions.assertTrue(updateSuccess);
        me = userDao.getById(6L);
        // 对比更新前，只更新了email字段
        Assertions.assertEquals(new User(6L, "garry", 30, "invalidEmail2"), me);
    }

    /**
     * 测试updateById是否只更新非null字段
     */
    @Test
    public void test_UpdateById() {
        var toUpdateValue = new User(6L,"garry",null,"invalidEmail");

        var updateSuccess = userDao.updateById(toUpdateValue);
        Assertions.assertTrue(updateSuccess);

        var me = userDao.getById(6L);
        // 对比更新前，只更新了email字段
        Assertions.assertEquals(new User(6L, "garry", 30, "invalidEmail"), me);
    }

    @Test
    public void test_ListNeverReturnNull() {
        var noEmail = userDao.list(new LambdaQueryWrapper<User>().eq(User::getEmail, "NoEmail"));
        Assertions.assertNotNull(noEmail);
        Assertions.assertEquals(noEmail.size(), 0);
    }

    @Test
    public void test_InsertThrowDuplicateException() {
        var existOne = new User(null,"garry",null,"invalidEmail");
        Assertions.assertThrows(DuplicateKeyException.class, ()->userDao.save(existOne));
    }

    @Test
    public void test_deleteByName() {
        var deleteCondition = new LambdaUpdateWrapper<User>()
                .eq(User::getName, "Sandy");
        Predicate<List<User>> hasUserCalledSandy = (users) -> users.stream().anyMatch(user -> Objects.equals(user.getName(), "Sandy"));
        var list = userDao.list();
        Assertions.assertTrue(hasUserCalledSandy.test(list));
        var removed = userDao.remove(deleteCondition);
        Assertions.assertTrue(removed);
        list = userDao.list();
        Assertions.assertFalse(hasUserCalledSandy.test(list));
    }

    @Test
    public void test_method_saveOrUpdate() {
        var me = userDao.getById(6);
        System.out.println(me);
        me.setName(null);
        userDao.saveOrUpdate(me);
        me = userDao.getById(6);
        System.out.println(me);
    }

    @Test
    public void xxx() {
        var user = userDao.getUser(1);
        System.out.println(user);
        user = userDao.getUser(7);
        System.out.println(user);
    }

}
