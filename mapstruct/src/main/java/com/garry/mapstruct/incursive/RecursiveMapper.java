package com.garry.mapstruct.incursive;

import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guyu06
 * @date 2022/11/16 00:01
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
@Service
public interface RecursiveMapper {
    @Mapping(target = "items", source = "itemsList")
    @Mapping(target = "key", constant = "districtId")
    FilterItemVo map(FilterItem source);
    @Mapping(target = "key", constant = "tradingAreaId")
    FilterItemVo map(FilterSubItem source);

}
