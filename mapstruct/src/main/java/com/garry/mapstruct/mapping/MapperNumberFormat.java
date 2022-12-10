package com.garry.mapstruct.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2022/11/12 20:21
 */
@Mapper(componentModel = "spring")
@Service
public interface MapperNumberFormat {
    @Mapping(source = "price", target = "price", numberFormat = "$#.00")
    @Mapping(target = "wanPrice", expression = "java(cn.hutool.core.util.NumberUtil.decimalFormat(\"0.00\", Long.parseLong(source.getWanPrice()) / 10000.0))")
    TheDto map(TheEntity source);
}
