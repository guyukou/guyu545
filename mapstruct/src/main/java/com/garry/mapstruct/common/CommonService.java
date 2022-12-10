package com.garry.mapstruct.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guyu06
 * @date 2022/11/9 16:16
 */
@Service
public class CommonService {
    @Autowired
    private CommonMapper commonMapper;

    public WrapperB startMap(WrapperA wrapperA) {
        return commonMapper.map(true, wrapperA);
    }


}
