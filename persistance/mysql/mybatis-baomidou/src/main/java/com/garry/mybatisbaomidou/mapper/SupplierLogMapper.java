package com.garry.mybatisbaomidou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garry.mybatisbaomidou.dos.SupplierLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierLogMapper extends BaseMapper<SupplierLog> {
    int selectCount(@Param("shard") String shard, @Param("start")int start, @Param("end")int end);
    List<SupplierLog> selectPage(@Param("shard") String shard, @Param("start")int start, @Param("end")int end, @Param("a")int a, @Param("b")int b);
}
