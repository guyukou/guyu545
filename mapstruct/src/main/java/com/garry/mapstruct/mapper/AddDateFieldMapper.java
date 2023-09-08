package com.garry.mapstruct.mapper;

import com.garry.mapstruct.bean.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author guyu06
 * @date 2023/2/17 00:06
 */
@Mapper
public interface AddDateFieldMapper {
    AddDateBeanA toA(AddDateBeanB b);
}
