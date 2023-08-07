package com.garry.mybatisbaomidou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garry.mybatisbaomidou.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author guyu06
 * @date 2023/4/4 22:13
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select name from user where id = #{id}")
    User mysql(@Param("id") long id);

}
