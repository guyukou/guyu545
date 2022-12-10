package com.garry.multidatasourcemybatisplus.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author guyu06
 * @date 2022/8/24 11:55 下午
 */
@Data
@TableName("tri_role")
public class TriRolePO {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
}
