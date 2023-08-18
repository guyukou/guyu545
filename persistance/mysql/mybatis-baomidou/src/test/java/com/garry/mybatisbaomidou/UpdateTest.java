package com.garry.mybatisbaomidou;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.garry.mybatisbaomidou.dao.UserDao;
import com.garry.mybatisbaomidou.user.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static com.garry.mybatisbaomidou.enums.SexEnum.FEMALE;
import static com.garry.mybatisbaomidou.enums.SexEnum.MALE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author guyu06
 * @date 2023/4/4 22:14
 */
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserDao userDao;

    private static final User user1 = new User(1L, MALE, "garry", 30, 1, "guyu545kou@gmail.com");
    private static final User user2 = new User(2L, FEMALE, "lily", 18, 1, "lily@world.com");

    @BeforeEach
    public void init() {
        userDao.save(user1);
        userDao.save(user2);
    }


    /**
     * 部分更新推荐的做法，param1传更新参数，param2传where条件
     */
    @Test
    public void test_updatePart_1() {
        var updateParams = new User(null, null, null, null, 1, "invalidEmail");
        var whereCondition = new LambdaQueryWrapper<User>()
                .eq(User::getId, 1L);
        userDao.update(updateParams, whereCondition);

        var actualValue = userDao.getById(1L);
        // 部分更新验证：只更新了email
        var expectedValue = copy(user1);
        expectedValue.setEmail("invalidEmail");
        assertEquals(expectedValue, actualValue);
    }

    /**
     * 部分更新另一个方式
     */
    @Test
    public void test_updatePart_2() {
        userDao.update(
                new LambdaUpdateWrapper<User>()
                        .eq(User::getName, "lily")
                        .set(User::getAge, 16)
        );
        var actualValue = userDao.getById(2L);
        // 对比更新前，只更新了email字段
        var expectedValue = copy(user2);
        expectedValue.setAge(16);
        assertEquals(expectedValue, actualValue);
    }

    /**
     * 部分更新: updateById
     */
    @Test
    public void test_updatePart_byId() {
        var updateParams = new User(1L, null, null, 2, 1, "invalidEmail");
        userDao.updateById(updateParams);

        var actualValue = userDao.getById(1L);
        var expectedValue = copy(user1);
        expectedValue.setEmail("invalidEmail");

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_save_callbackId() {
        var nick = new User(null, MALE, "nick", 12, 1, "nick@gmail.com");
        userDao.save(nick);
        assertNotNull(nick.getId());


        var tom = new User(null, MALE, "tom", 3, 1, "tom@gmail.com");
        var jerry = new User(null, MALE, "jerry", 3, 1, "jerry@gmail.com");
        userDao.saveBatch(Lists.newArrayList(tom, jerry));
        assertNotNull(tom.getId());
        assertNotNull(jerry.getId());
    }

    @Test
    public void test_ListNeverReturnNull() {
        var noEmail = userDao.list(new LambdaQueryWrapper<User>().eq(User::getEmail, "NoEmail"));
        Assertions.assertNotNull(noEmail);
        assertEquals(noEmail.size(), 0);
    }

    @Test
    public void test_InsertThrowDuplicateException() {
        var existOne = new User(null, null, "garry", null, 1, "invalidEmail");
        Assertions.assertThrows(DuplicateKeyException.class, () -> userDao.save(existOne));
    }

    @Test
    public void test_deleteByName() {
        var deleteCondition = new LambdaUpdateWrapper<User>()
                .eq(User::getName, "Sandy");
        Predicate<List<User>> hasUserCalledSandy = (users) -> users.stream().anyMatch(user -> Objects.equals(user.getName(), "Sandy"));
        var list = userDao.list();
        assertTrue(hasUserCalledSandy.test(list));
        var removed = userDao.remove(deleteCondition);
        assertTrue(removed);
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


    private User copy(User source) {
        return new User(source.getId(), source.getSex(), source.getName(), source.getAge(), 1, source.getEmail());
    }
}
