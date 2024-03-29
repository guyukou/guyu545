package com.garry.mybatisbaomidou.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.garry.mybatisbaomidou.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guyu06
 * @date 2023/4/4 22:13
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private SexEnum sex;
    private String name;
    private Integer age;
    @Version
    private Integer version;
    private String email;
}