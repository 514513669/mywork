package com.mrlong.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期转换
 *
 * @author admin
 * @date 2020-08-12
 */
public class DateUtil {

    private static final String YYMMDD_HMS_24 = "yyyy/MM/dd HH:mm:ss";

    /**
     * 将String类型转换成Date类型
     *
     * @param time String型的时间
     * @return Date
     */
    public static Date getStringToDate(String time) {
        return getStringToDate(time, YYMMDD_HMS_24);
    }

    /**
     * 将String类型转换成Date类型
     *
     * @param time      时间
     * @param dateModel 时间模版格式
     * @return Date
     */
    public static Date getStringToDate(String time, String dateModel) {
        if (time == null || "".equals(time)) {
            return null;
        } else {
            SimpleDateFormat sd = new SimpleDateFormat(dateModel);
            Date date = null;
            try {
                date = sd.parse(time);
            } catch (ParseException e) {
                //log.error("error", e);
            }
            return date;
        }
    }

    /**
     * 将Date类型转换成String类型
     *
     * @param date 输入的时间
     * @return String
     */
    public static String getDateToString(Date date) {
        return getDateToString(date, YYMMDD_HMS_24);
    }

    /**
     * 将Date类型转换成String类型
     *
     * @param date      传入的时间
     * @param dateModel 时间格式模板
     * @return java.util.String
     */
    public static String getDateToString(Date date, String dateModel) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sd = new SimpleDateFormat(dateModel);
            return sd.format(date);
        }
    }

    /**
     * 把日期转换成汉字
     *
     * @param sDate         传入的时间 "2002/01/01"
     * @param delimeterChar 分隔符 "/"
     * @return String 二零零二年一月一日
     */
    public static String getDateCn(String sDate, String delimeterChar) {
        StringBuilder buffer = new StringBuilder();
        String[] tmpArr = sDate.split(delimeterChar);
        String[] dArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        for (int i = 0; i < 10; i++) {
            String temp = Integer.valueOf(i).toString();
            tmpArr[0] = tmpArr[0].replaceAll(temp, dArr[i]);
        }
        buffer.append(tmpArr[0]).append("年");

        if (tmpArr[1].length() == 1) {
            buffer.append(dArr[Integer.parseInt(tmpArr[1])]).append("月");
        } else {
            if ("0".equals(tmpArr[1].substring(0, 1))) {
                buffer.append(dArr[Integer.parseInt(tmpArr[1].substring(1))]).append("月");
            } else {
                buffer.append("十").append(dArr[Integer.parseInt(tmpArr[1].substring(1))]).append("月");
            }
        }

        if (tmpArr[2].length() == 1) {
            buffer.append(dArr[Integer.parseInt(tmpArr[2])]).append("日");
        } else {
            if ("0".equals(tmpArr[2].substring(0, 1))) {
                buffer.append(dArr[Integer.parseInt(tmpArr[2].substring(1))]).append("日");
            } else {
                buffer.append(dArr[Integer.parseInt(tmpArr[2].substring(0, 1))]);
                buffer.append("十");
                buffer.append(dArr[Integer.parseInt(tmpArr[2].substring(1))]);
                buffer.append("日");
            }
        }
        return buffer.toString().replaceAll("零 ", "");
    }

    /**
     * 计算两个日期的差，结果精确到天
     *
     * @param startDate String 开始日期（固定格式：yyyy/MM/dd）
     * @param endDate   String 结束日期（固定格式：yyyy/MM/dd）
     * @return long
     */
    public static long getCompareDate(String startDate, String endDate, String template) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(template);
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(endDate);
        long l = date2.getTime() - date1.getTime();
        return l / (24 * 60 * 60 * 1000);
    }


    /**
     * 计算两个时间差，结果精确到毫秒
     *
     * @param startTime 开始时间（固定格式：yyyy-MM-dd HH:mm:ss）
     * @param endTime   结束时间（固定格式：yyyy-MM-dd HH:mm:ss）
     * @return long
     */
    public static long getTimeDiff(String startTime, String endTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(YYMMDD_HMS_24);
        Date date1 = formatter.parse(startTime);
        Date date2 = formatter.parse(endTime);
        return date2.getTime() - date1.getTime();
    }

    /**
     * 计算两个时间差，结果精确到毫秒
     *
     * @param startTime Date 开始日期
     * @param endTime   Date 结束日期
     * @return long
     */
    public static long getDateTimeDiff(Date startTime, Date endTime) {
        return endTime.getTime() - startTime.getTime();
    }

    /**
     * 将时间戳转换成时间字符串
     *
     * @param stamp 时间戳
     * @return String
     */
    public static String stampToString(long stamp) {
        return stampToString(stamp, YYMMDD_HMS_24);
    }

    /**
     * 将时间戳转换成时间字符串
     *
     * @param stamp    时间戳
     * @param template 时间模板
     * @return String
     */
    public static String stampToString(long stamp, String template) {
        SimpleDateFormat sdf = new SimpleDateFormat(template);
        return sdf.format(new Date(stamp));
    }

    /**
     * 该方法功能详细描述： 计算daysTime 的毫秒数，daysTime 是以天为单位计算。
     *
     * @param daysTime ——以天为单位，
     * @return java.lang.Long
     */
    public static Long dataToTimeDiff(int daysTime) {
        //每天的毫秒数
        long oneDayTimeDiff = 24 * 60 * 60 * 1000;
        //计算总共的毫秒数
        return oneDayTimeDiff * daysTime;
    }

    /**
     * 将时间戳字符串转成  年月日字符串
     *
     * @param time 格式如  1494249676000
     * @return String
     */
    public static String stampToDate(String time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYMMDD_HMS_24);
        long lt = new Long(time);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 某日期加间隔天数后日期
     *
     * @param startDate 日期
     * @param interval  间隔天数
     * @return 返回计算后日期
     */
    public static Date getAfterIntervalDate(Date startDate, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, interval);
        return calendar.getTime();
    }

    /**
     * 某日期加间隔小时数后日期
     *
     * @param startDate 日期
     * @param interval  小时数
     * @return 返回计算后的日期
     */
    public static Date getAfterIntervalHourDate(Date startDate, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.HOUR_OF_DAY, interval);
        return calendar.getTime();
    }

    /**
     * 某日期加间隔分钟数后日期
     *
     * @param startDate 日期
     * @param interval  分钟数
     * @return 返回计算后的日期
     */
    public static Date getAfterIntervalMInDate(Date startDate, int interval) {
        Date calendar = new Date();
        calendar.setTime((startDate.getTime() + interval * 60 * 1000));
        return calendar;
    }

    /**
     * 当天的起始时间   yyyy-MM-dd 00:00:00
     *
     * @param date 日期
     * @return 返回当天的起始时间
     */
    public static Date getDateStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }


    /**
     * 当天的结束时间
     *
     * @param date 日期
     * @return 返回当天的结束时间
     */
    public static Date getDateEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 得到给定日期所在月份的最后一天
     *
     * @param date 日期
     * @return 得到给定日期所在月份的最后一天的日期
     */
    public static Date getLastDateOfMonth(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.MONTH, 1);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), 1);
        gc.add(Calendar.DAY_OF_MONTH, -1);
        return gc.getTime();
    }

    /**
     * 得到给定日期所在月份的第一天
     *
     * @param date 日期
     * @return 得到给定日期所在月份的第一天的日期
     */
    public static Date getFirstDateOfMonth(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), 1);
        return gc.getTime();
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static Date getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        c.add(Calendar.DATE, -dayOfWeek + 1);
        return c.getTime();
    }


    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static Date getSundayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        c.add(Calendar.DATE, -dayOfWeek + 7);
        return c.getTime();
    }

    /**
     * 某日期加间隔月后日期
     *
     * @param startDate 日期
     * @param interval  月数
     * @return 返回某日期加间隔月后日期
     */
    public static Date getAfterIntervalMonth(Date startDate, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, interval);
        return calendar.getTime();
    }

    /**
     * 得到给定日期所在interval月份的第一天
     *
     * @param date 日期
     * @return 获取日期
     */
    public static Date getFirstDateOfIntervalMonth(Date date, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, interval);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 得到给定日期所在interval月份的最后一天
     *
     * @param date 日期
     * @return 返回得到给定日期所在interval月份的最后一天
     */
    public static Date getLastDateOfIntervalMonth(Date date, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + interval);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

}
