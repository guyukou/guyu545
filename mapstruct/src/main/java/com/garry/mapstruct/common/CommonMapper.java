package com.garry.mapstruct.common;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2022/11/9 16:15
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Service
public interface CommonMapper {
    @Mapping(target = "show", source = "show")
    @Mapping(target = "inner.strB", source = "wrapperA.inner.strA")
    WrapperB map(boolean show, WrapperA wrapperA);

//    @Mapping(target = "str", source = "wrapperA.str")
    String map(WrapperA wrapperA);


}
