package com.garry.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guyu06
 * @date 2023/6/6 17:18
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDateBeanA {

    /**
     * 门店skuId
     */

    private Long originMendianSkuId;

    /**
     * 类别ID
     */

    private int cateId;
    /**
     * 城市ID
     */

    private int cityId;
    /**
     * 小区ID
     */

    private long xiaoquId;
    /**
     * 公司ID
     */

    private long companyId;

    private long mendianId;
    /**
     * 标题
     */

    private String title;
    /**
     * 房源详情
     */

    private Map<String, String> content = new HashMap<>();
    /**
     * 参数
     */

    private Map<String, String> params = new HashMap<>();
    /**
     * 新增时间
     */

    private long addDate;
    /**
     * 修改时间
     */

    private long postDate;
    /**
     * 状态
     */

    private int state;
    /**
     * casLock
     */

    private int casLock;
    /**
     * 锁定字段
     */

    private List<String> lockFields = new ArrayList<>();

}
