package com.guyu.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class G_Pattern {
    public static void main(String[] args) {
//        yearMonthMatch();
//        resolveYmd();
        Pattern brokerIdWithDatePattern = Pattern.compile("(\\d+):([\\d+]{4}-[\\d+]{2}-[\\d+]{2})");
        String key = "1500843:2022-09-14:0:1";
        Matcher matcher = brokerIdWithDatePattern.matcher(key);
        matcher.find();
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }


    /**
     * 输入字符串为1501206:2022-09-14:0:1，包含了年月日2022-09-14，需要解析并返回这个字符串
     */
    private static void resolveYmd() {
        final Pattern ymdPattern = Pattern.compile("([\\d]{4}-[\\d]{2}-[\\d]{2})");
        String inputStr = "1501206:2022-09-14:0:1";

        Matcher matcher = ymdPattern.matcher(inputStr);
        matcher.find(); // 调用.group()之前必选调用.find()
        System.out.println(matcher.group());
    }

    private static void yearMonthMatch() {
        Pattern yearMonth = Pattern.compile("20\\d\\d(0[1-9]|1[0-2])");
        List<String> monthes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            monthes.add("0" + i);
        }
        monthes.add("11");
        monthes.add("12");
        for (String monthe : monthes) {
            System.out.println("2022"+monthe + " match?: " + yearMonth.matcher("2022"+monthe).matches());
            if (!yearMonth.matcher("2022"+monthe).matches()) {
                System.err.println(monthe + " doesnt match");
            }
        }
    }
}
