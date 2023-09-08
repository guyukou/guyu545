package com.garry.mapstruct.mapper;

import com.garry.mapstruct.bean.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import javax.naming.ReferralException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guyu06
 * @date 2023/2/17 00:06
 */
@Mapper
public interface DefaultMapper {
    SameBeanA mapSingleOfSame(SameBeanB source);

    RefBeanA mapSameClass(RefBeanA source);
    List<SameBeanA> mapListOfSame(List<SameBeanB> source);

    @Mapping(target = "id", source = "identifier")
    @Mapping(target = "name", source = "trueName")
    @Mapping(target = "address", source = "dizhi", defaultExpression = "java(com.google.common.collect.Lists.newArrayList())")
    DistinctBeanA mapSingleOfDistinct(DistinctBeanB source);

//    @Mapping(target = "age", source = "s2")
//    @Mapping(target = "params", expression = "java(this.mapToMap(s1))")
//    MapFieldBean mapToMapField(String s1, Integer s2);

}
