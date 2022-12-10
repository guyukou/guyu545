package com.garry.mapstruct.typeconvert;

import com.garry.mapstruct.MapHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author guyu06
 * @date 2022/11/19 11:20
 */
@Mapper(uses = MapHelper.class)
public interface TheMapper {

    @Mapping(target = "bool1", source = "int1")
    @Mapping(target = "bool2", source = "int2")
    BeanBool toBool(BeanInt source);

    @Mapping(target = "int1", source = "bool1")
    @Mapping(target = "int2", source = "bool2")
    BeanInt toInt(BeanBool source);


    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    class BeanBool {
        boolean bool1;
        boolean bool2;
    }

    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    class BeanInt {
        int int1;
        int int2;
    }
}
