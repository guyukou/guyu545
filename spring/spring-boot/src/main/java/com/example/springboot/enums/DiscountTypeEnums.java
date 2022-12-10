package com.example.springboot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * 折扣组
 */
@Getter
public enum DiscountTypeEnums {

    /**
     * 全部
     */
    ALL(0, "全部类型折扣","全部类型折扣",-1),

    /**
     * ssp VIP折扣
     */
    VIP(1, "基础折扣","会员权益",3),

    /**
     * ssp时长折扣
     */
    TIME(2, "订单折扣","时长折扣",2),

    /**
     * 营销折扣
     */
    MARKETING(3, "营销折扣","营销折扣",4),

    /**
     * ssp自动续费折扣
     */
    RENEW(4, "续费折扣","自动续费",-1),

    /**
     * 早八晚八折扣
     */
    AM8PM8(5, "早八晚八折扣","早八晚八折扣",-1),

    /**
     * 双投折扣
     */
    DOUBLE_SPREAD(7, "双投折扣","双网折扣",5),

    /**
     * 阶梯折扣
     */
    LADDER(8, "阶梯折扣","阶梯折扣",6),

    /**
     * 一口价折扣【限量秒杀折扣】
     */
    FIXED_PRICE(10, "一口价折扣","限量秒杀折扣",-1),

    /**
     * sku房源折扣【天降红包折扣】
     */
    SKU(11, "sku折扣","天降红包折扣",1),
    ;

    private Integer code;

    /**
     * 营销侧定义的描述
     */
    private String desc;

    /**
     * 需要展示给在页面上的描述
     */
    private String showDesc;

    /**
     * 折扣规则顺序；-1代表不参与折扣顺序排序
     */
    private Integer discountRuleOrder;

    DiscountTypeEnums(Integer code, String desc,String showDesc,Integer discountRuleOrder) {

        this.code = code;
        this.desc = desc;
        this.showDesc = showDesc;
        this.discountRuleOrder = discountRuleOrder;
    }

    public static DiscountTypeEnums getEnum(Integer discountType) {

        for (DiscountTypeEnums value : DiscountTypeEnums.values()) {

            if (value.getCode().intValue() == discountType.intValue()) {
                return value;
            }
        }

        return null;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DiscountTypeEnums getEnum(String discountType) {
        return getEnum(Integer.parseInt(discountType));
    }

}
