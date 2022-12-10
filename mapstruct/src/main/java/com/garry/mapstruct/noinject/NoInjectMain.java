package com.garry.mapstruct.noinject;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author guyu06
 * @date 2022/11/17 16:24
 */
public class NoInjectMain {
    private final TheMapper theMapper = Mappers.getMapper(TheMapper.class);

    BeanB startMap(BeanA wrapperA) {
        return theMapper.map(wrapperA);
    }

    @Mapper
    interface TheMapper {
        @Mapping(source = "show", target = "showB")
        @Mapping(source = "str", target = "strB")
//        @Mapping(source = "communityId", target = "communityIds")
        BeanB map(BeanA source);
    }
}
