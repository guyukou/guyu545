package com.guyu.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-04-21
 */
public class LocalDateUtils {

    /**
     * 格式yyyy-MM-dd, 如2022-04-12
     */
    public static final DateTimeFormatter STD_DATE_A = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * 格式yyyyMMdd, 如20220412
     */
    public static final DateTimeFormatter STD_DATE_B = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 格式yyyyMM，如202204
     */
    public static final DateTimeFormatter STD_YEAR_MONTH_B = DateTimeFormatter.ofPattern("yyyyMM");
    /**
     * 标准日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter STD_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(LocalDate localDate) {
        return localDate.format(STD_DATE_A);
    }
    public static String formatDate(LocalDate localDate, DateTimeFormatter formatter) {
        return localDate.format(formatter);
    }

    public static String formatDate(long timestamp, DateTimeFormatter formatter) {
        return timestamp2LocalDate(timestamp).format(formatter);
    }

    public static String formatDatetime(long timestamp, DateTimeFormatter formatter) {
        return timestamp2LocalDateTime(timestamp).format(formatter);
    }

    public static String formatDatetime(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return localDateTime.format(formatter);
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, STD_DATE_A);
    }

    public static LocalDate parseDate(String dateStr, DateTimeFormatter formatter) {
        return LocalDate.parse(dateStr, formatter);
    }

    public static LocalDate parseDateFromTime(String dateStr) {
        return parseDateTime(dateStr).toLocalDate();
    }


    public static LocalDateTime parseDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, STD_DATE_TIME);
    }

    public static LocalDateTime parseDateTime(String dateStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * 返回当前时间yyyyMMdd格式的数值类型
     * @return omitted
     */
    public static String getYmdOfToday() {
        return LocalDate.now().format(STD_DATE_B);
    }

    public static String ymStr(LocalDate localDate) {
        return localDate.format(STD_YEAR_MONTH_B);
    }

    public static long increaseTimestamp(long timestamp, long time, ChronoUnit timeUnit) {
        LocalDateTime localDateTime = timestamp2LocalDateTime(timestamp);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime.plus(time, timeUnit), ZoneId.systemDefault());
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static LocalDate timestamp2LocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime timestamp2LocalDateTime(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static long nowUnixMillisecond() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    public static long getYearBeginMillis() {
        return LocalDateTime.of(LocalDate.now().getYear(), 1, 1, 0, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }

    /**
     * 获取unix时间戳，单位秒
     * @return
     */
    private static long getUnixTime() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取输入localDate所在月份1号日期
     * @param localDate 输入
     * @see LocalDate#atStartOfDay()
     * @return localDate所在月份1号日期
     */
    public static LocalDate atStartOfMonth(LocalDate localDate) {
        return localDate.withDayOfMonth(1);
    }

    public static void main(String[] args) {
        var localDateTime = LocalDateTime.now().minusMinutes(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli());
    }


}
