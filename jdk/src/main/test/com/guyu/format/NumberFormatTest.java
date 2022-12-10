package com.guyu.format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author guyu06
 * @date 2022/11/12 20:28
 */
public class NumberFormatTest {

    @Test
    void formatDouble() {
        double d = 12345.78;
        Assertions.assertEquals(new DecimalFormat("#").format(d), "12346");
        Assertions.assertEquals(new DecimalFormat("#.").format(d), "12346.");
        Assertions.assertEquals(new DecimalFormat("#.#").format(d), "12345.8");
        d = 12345.10;
        Assertions.assertEquals(new DecimalFormat("#.00").format(d), "12345.10");
        Assertions.assertEquals(new DecimalFormat("#.##").format(d), "12345.1");
        d = 12345.00;
        Assertions.assertEquals(new DecimalFormat("#.##").format(d), "12345");
        d = 12345.565;
        Assertions.assertEquals(new DecimalFormat("#.##").format(d), "12345.57");
        // 入参不能是null
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DecimalFormat("#.##").format(null));
    }

    @Test
    void formatBigDecimal() {
        BigDecimal b = new BigDecimal("12345.78");
        Assertions.assertEquals(new DecimalFormat("#").format(b), "12346");
        b = new BigDecimal("12345.10");
        Assertions.assertEquals(new DecimalFormat("#.00").format(b), "12345.10");
        Assertions.assertEquals(new DecimalFormat("#.##").format(b), "12345.1");
        b = new BigDecimal("12345.00");
        Assertions.assertEquals(new DecimalFormat("#.##").format(b), "12345");
    }
}
