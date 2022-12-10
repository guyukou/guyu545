package com.garry.tools.template;

import org.stringtemplate.v4.ST;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板工具：ST。
 * 变量格式为<param>
 */
public class G_ST {
    public static void main(String[] args) {
        String template = "低至<value>元/天";
//        String template = "hello, name, welcome to city.";
        ST st = new ST(template);
        Map<String, Object> params = new HashMap<>();
        double price1 = 18774720;
        double price2 = 6220800;
        params.put("value", processFinalPrice(price1).add(processFinalPrice(price2)));
        params.forEach(st::add);
        System.out.println(st.render());
    }
    private static BigDecimal processFinalPrice(double price) {
        return new BigDecimal(price / 1000000).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
