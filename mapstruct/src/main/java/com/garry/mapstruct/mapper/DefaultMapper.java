package com.garry.mapstruct.mapper;

import com.garry.mapstruct.bean.DistinctBeanA;
import com.garry.mapstruct.bean.DistinctBeanB;
import com.garry.mapstruct.bean.SameBeanA;
import com.garry.mapstruct.bean.SameBeanB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author guyu06
 * @date 2023/2/17 00:06
 */
@Mapper
public interface DefaultMapper {
    SameBeanA mapSingleOfSame(SameBeanB source);
    List<SameBeanA> mapListOfSame(List<SameBeanB> source);

    @Mapping(target = "id", source = "identifier")
    @Mapping(target = "name", source = "trueName")
    @Mapping(target = "address", source = "dizhi", defaultExpression = "java(com.google.common.collect.Lists.newArrayList())")
    DistinctBeanA mapSingleOfDistinct(DistinctBeanB source);
}
