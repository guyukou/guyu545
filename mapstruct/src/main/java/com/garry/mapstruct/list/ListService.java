package com.garry.mapstruct.list;

import com.garry.mapstruct.BeanA;
import com.garry.mapstruct.BeanB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guyu06
 * @date 2022/11/18 11:39
 */
public class ListService {
    private final TheMapper theMapper = Mappers.getMapper(TheMapper.class);
    public List<BeanB> startMap(List<BeanA> aList) {
        return theMapper.map(aList);
    }

    @Mapper
    interface TheMapper {
        List<BeanB> map(List<BeanA> source);

        @Mapping(target = "communityIds", expression = "java(null)")
        @Mapping(source = "show", target = "showB")
        @Mapping(source = "str", target = "strB")
        BeanB map(BeanA source);
    }
}
