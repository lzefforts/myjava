package org.study.java8.time;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 时间util
 * @author ArnoldLee
 * @date 2019/5/17
 */
public class TimeUtil {

    public static String defaultPattern = "yyyy-MM-dd HH:mm:ss";
    public static String pattern1 = "yyyyMMdd HHmmss";
    public static String pattern2 = "yyyyMMddHHmmss";

    /**
     *  获取当前时间
     *  @param pattern 日期格式
     **/
    public static String getNowStrByStyle(String pattern){
        if(StringUtils.isNotEmpty(pattern)){
            pattern = defaultPattern;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }

    /**
     *  日期加几小时
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param hours 小时数
     **/
    public static String plusHours(String timeStr,String pattern,long hours){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.plusHours(hours);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }

    /**
     *  日期加几天
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param days 天数
     **/
    public static String plusDays(String timeStr,String pattern,long days){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }

    /**
     *  日期加几年
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param years 年数
     **/
    public static String plusYears(String timeStr,String pattern,int years){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.plusYears(years);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }



    /**
     *  日期加几小时
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param hours 小时数
     **/
    public static String minusHours(String timeStr,String pattern,long hours){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.minusHours(hours);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }
    /**
     *  日期减几天
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param days 天数
     **/
    public static String minusDays(String timeStr,String pattern,long days){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.minusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }

    /**
     *  日期减几年
     *  @param timeStr 时间
     *  @param pattern 日期格式
     *  @param years 年数
     **/
    public static String minusYears(String timeStr,String pattern,int years){
        LocalDateTime localDateTime = getLocalDateTime(timeStr,pattern);
        localDateTime.minusYears(years);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String nowTimeStr = formatter.format(localDateTime);
        return nowTimeStr;
    }


    /**
     *  日期之间差几小时
     *  @param beginStr 开始时间
     *  @param endStr 结束时间
     *  @param pattern 日期格式
     *
     **/
    public static long timeBetweenHours(String beginStr,String endStr,String pattern){
        LocalDateTime beginTime = getLocalDateTime(beginStr,pattern);
        LocalDateTime endTime = getLocalDateTime(endStr,pattern);
        long hours = endTime.until(beginTime, ChronoUnit.HOURS);
        return hours;
    }

    /**
     *  日期之间差几天
     *  @param beginStr 开始时间
     *  @param endStr 结束时间
     *  @param pattern 日期格式
     *
     **/
    public static long timeBetweenDays(String beginStr,String endStr,String pattern){
        LocalDateTime beginTime = getLocalDateTime(beginStr,pattern);
        LocalDateTime endTime = getLocalDateTime(endStr,pattern);
        long days = endTime.until(beginTime, ChronoUnit.DAYS);
        return days;
    }

    /**
     *  日期之间差几年
     *  @param beginStr 开始时间
     *  @param endStr 结束时间
     *  @param pattern 日期格式
     *
     **/
    public static long timeBetweenYears(String beginStr,String endStr,String pattern){
        LocalDateTime beginTime = getLocalDateTime(beginStr,pattern);
        LocalDateTime endTime = getLocalDateTime(endStr,pattern);
        long years = endTime.until(beginTime, ChronoUnit.YEARS);
        return years;
    }

    /**
     *  日期比较
     *  当beginStr<endStr时,返回false
     *  当beginStr>=endStr时,返回true
     *  @param aTimeStr 开始时间
     *  @param bTimeStr 结束时间
     *  @param pattern 日期格式
     *
     **/
    public static boolean timeCompare(String aTimeStr,String bTimeStr,String pattern){
        LocalDateTime aTime = getLocalDateTime(aTimeStr,pattern);
        LocalDateTime bTime = getLocalDateTime(bTimeStr,pattern);
        int result = aTime.compareTo(bTime);
        if(result < 0){
            return false;
        }
        return true;
    }


    private static LocalDateTime getLocalDateTime(String timeStr, String pattern) {
        if(StringUtils.isNotEmpty(pattern)){
            pattern = defaultPattern;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(timeStr,formatter);
        return localDateTime;
    }


}
