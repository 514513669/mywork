package com.mrlong.demo.utils;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 基于JDK 1.8 日期API
 *
 * @author xingchen
 * @date 2018/12/10下午2:21
 */
public class DateUtils {

    private static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYYMMDD = "yyyy-MM-dd";
    private static final String YYYYMM = "yyyy-MM";

    /**
     * 将日期转为字符串 yyyy-mm-dd HH:mm:ss
     *
     * @param date 日期
     * @return 返回格式换后的字符串
     */
    public static String getYYYYMMDDHHMMSS(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
        LocalDateTime localDateTime = dateToDateTime(date);
        return formatter.format(localDateTime);
    }

    /**
     * 将字符串转为日期
     *
     * @param date 日期字符串
     * @return 返回日期
     */
    public static Date getDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 将字符串转为日期
     *
     * @param date    日期
     * @param pattern 格式换字符串
     * @return 返回日期
     */
    public static Date getDate(String date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        return dateTimeToDate(localDateTime);
    }

    /**
     * LocalDateTime 和DateTime 互转
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime dateToDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime LocalDateTime
     * @return Date
     */
    public static Date dateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * date 转LocalDate
     *
     * @param date Date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * date 转LocalDate
     *
     * @param localDate LocalDate
     * @return Date
     */
    public static Date localToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * date 转DateTime
     *
     * @param date Date
     * @return LocalTime
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * date 转LocalTime
     *
     * @param localTime LocalTime
     * @return Date
     */
    public static Date localToDate(LocalTime localTime) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 将日期转为字符串 yyyy-mm-dd
     *
     * @param date Date
     * @return 转换后的字符串
     */
    public static String getYYYYMMDD(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDD);
        LocalDateTime localDateTime = dateToDateTime(date);
        return formatter.format(localDateTime);
    }

    /**
     * 将日期转为字符串 yyyy-mm-dd
     *
     * @param date Date
     * @return 返回字符串
     */
    public static String getYYYYMM(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMM);
        LocalDateTime localDateTime = dateToDateTime(date);
        return formatter.format(localDateTime);
    }

    /**
     * 获取当前时间之后的某一天的最小时间
     *
     * @param date 日期
     * @return Date
     */
    public static Date afterXDateTimeMIN(Date date, int after) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.plusDays(after);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取当前时间之后的某一天的最大时间
     *
     * @param date
     * @return
     */
    public static Date afterXDateTimeMAX(Date date, int after) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.plusDays(after);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取当前时间之前的某一天的最小时间
     *
     * @param date
     * @return
     */
    public static Date beforeXDateTimeMIN(Date date, int before) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.minusDays(before);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前时间之前的某一天的最大时间
     *
     * @param date
     * @return
     */
    public static Date beforeXDateTimeMAX(Date date, int before) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.minusDays(before);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取本月的第一天 00:00:00
     *
     * @return 本月第一天日期
     */
    public static Date currentFirstDayOfMonth() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取传入时间月份的最后一天
     *
     * @return 当前月的最后一天
     */
    public static Date currentXDayOfMonth(Date date) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 所选date的月份的第一天
     *
     * @return 当前月的第一天
     */
    public static Date beforeXFirstDayOfMonth(Date date) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取前几个月的1号0点 00:00:00
     *
     * @return
     */
    public static Date preXDayOfMonthMIN(int month) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取前几个月的1号0点 00:00:00
     *
     * @return
     */
    public static Date preXDayOfMonthMIN(Date date, int month) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 传入时间的的前几个月的时间
     *
     * @return
     */
    public static Date preXDayOfMonth(Date date, int month) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 传入时间的的前几个月的时间
     *
     * @return
     */
    public static Date afterXDayOfMonth(Date date, int month) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.plusMonths(month);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取前几个月的最后一天23：59：59
     *
     * @return
     */
    public static Date preXDayOfMonthMAX(int month) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 获取某个时间几个月的最后一天23：59：59
     *
     * @return
     */
    public static Date preXDayOfMonthMAX(Date date, int month) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.minusMonths(month);
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return dateTimeToDate(localDateTime);
    }

    /**
     * 两个日期相差多少个月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long getUntilMonth(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return ChronoUnit.MONTHS.between(localDate1, localDate2);
    }

    /**
     * 两个日期相差多少天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long getUntilDay(Date date1, Date date2) {
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return ChronoUnit.DAYS.between(localDate1, localDate2);
    }

    /**
     * 两个日期相差多少小时
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long getUntilHours(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToDateTime(date1);
        LocalDateTime localDate2 = dateToDateTime(date2);
        long senonds = Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
        return senonds / 3600;
    }

    /**
     * 两个日期相差多少小时 double 约等于
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 差距
     */
    public static double getUntilHoursByDouble(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToDateTime(date1);
        LocalDateTime localDate2 = dateToDateTime(date2);
        long seconds = Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
        BigDecimal secondss = BigDecimal.valueOf(seconds);
        BigDecimal hours = secondss.divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
        return hours.doubleValue();
    }

    /**
     * 两个日期相差多少秒
     *
     * @param date1
     * @param date2
     * @return 秒
     */
    public static Long getUntilSecond(Date date1, Date date2) {
        LocalDateTime localDate1 = dateToDateTime(date1);
        LocalDateTime localDate2 = dateToDateTime(date2);
        return Duration.between(localDate1, localDate2).get(ChronoUnit.SECONDS);
    }

    public static void main(String[] args) {
        //LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(getYYYYMMDDHHMMSS(currentXDayOfMonth(new Date())));
    }

    /**
     * 当前时间23：59：59
     *
     * @param date 日期
     * @return 返回日期的结束时间
     */
    public static Date currentMax(Date date) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.with(LocalTime.MAX);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当前时间00:00:00
     *
     * @param date 日期
     * @return 返回日期的开始时间
     */
    public static Date currentMin(Date date) {
        LocalDateTime localDateTime = dateToDateTime(date);
        localDateTime = localDateTime.with(LocalTime.MIN);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}