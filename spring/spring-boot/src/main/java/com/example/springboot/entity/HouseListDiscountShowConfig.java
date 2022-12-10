package com.example.springboot.entity;

import com.example.springboot.enums.DiscountTypeEnums;
import lombok.Data;

import java.util.Map;

/**
 * 房源列表通用配置
 * Created on 2022/6/19
 */
@Data
public class HouseListDiscountShowConfig {
    private Map<DiscountTypeEnums, Integer> coefficient;
    private String titleShopRec; // 流量补贴
    private String templateShopRec; // 流量补贴文案：店长推荐房源置顶后即可享受列表页/单页特殊样式，房源曝光加权等流量补贴
    private Map<DiscountTypeEnums, String> titleDiscount;
    private Map<DiscountTypeEnums, String> templateDiscount;
    private String titleHighPotential; // 高潜力
    private String templateHighPotential21; // 第一个数字表示平台数量，第二个表示是否有折扣
    private String templateHighPotential20; //
    private String templateHighPotential11; //
    private String templateHighPotential100; //当前YY无人置顶，置顶后独享置顶位，展示机会预估提升X%～Y%
    private String templateHighPotential101; //YY置顶后可获得人气好房加权，享受列表页加权、醒目标签权益
    private String titleHighPotential101; // 人气好房
}
