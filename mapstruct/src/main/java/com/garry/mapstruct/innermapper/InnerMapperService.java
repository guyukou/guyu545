package com.garry.mapstruct.innermapper;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2022/11/9 16:16
 */
@Service
class InnerMapperService {
    @Autowired
    private TheMapper theMapper;

    BeanB startMap(BeanA wrapperA) {
        return theMapper.map(wrapperA);
    }

    @Mapper(componentModel = "spring")
    @Service
    interface TheMapper {
        @Mapping(source = "show", target = "showB")
        @Mapping(source = "str", target = "strB")
        BeanB map(BeanA source);
    }

}
