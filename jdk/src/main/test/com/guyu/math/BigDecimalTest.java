package com.guyu.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guyu06
 * @date 2022/9/28 5:48 PM
 */
public class BigDecimalTest {
    @Test
    void testFormat() {
        BigDecimal divisor = new BigDecimal(10000);
        assertEquals(doDivide(109949, divisor), "10.99");
        assertEquals(doDivide(109948, divisor), "10.99");
        assertEquals(doDivide(109900, divisor), "10.99");
        assertEquals(doDivide(109901, divisor), "10.99");
        assertEquals(doDivide(109950, divisor), "11.00");
        assertEquals(doDivide(109998, divisor), "11.00");
        assertEquals(doDivide(109999, divisor), "11.00");
    }

    private String doDivide(long divided, BigDecimal divisor) {
        return new BigDecimal(divided).divide(divisor, 2, RoundingMode.HALF_UP).toString();
    }
}
