package org.study.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateHelper {

    /**
     * 得到上个月的yyyymm
     *
     */
    public static String getLastYyyyMm() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return format(cal.getTime(), "yyyyMM");
    }

    /**
     * 得到上几个月的yyyyMM 比如，获取两个月前的，则i=-2
     *
     * @param i
     *
     */
    public static String getLastYyyyMm(int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, i);
        return format(cal.getTime(), "yyyyMM");
    }

    /**
     * 根据传入的日期得到上个月的年月
     *
     * @param date
     *
     */
    public static int getLastYyyymm(String date) throws Exception {
        Date d = getProcessDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, -1);
        return Integer.parseInt(format(cal.getTime(), "yyyyMM"));
    }

    /**
     * 获取传入天的相对日期
     *
     * @param d
     *
     */
    public static Date getDate(int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, d);
        return cal.getTime();
    }

    /**
     * 根据传入的小时，返回增加或减少后的时间
     */
    public static Date getDateWithHour(int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }

    /**
     * 获得昨天的日期
     *
     *
     */
    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 格式化日期为字符串
     *
     * @param date
     *            目标日期
     * @param pattern
     *            模式
     *
     */
    public static String format(Date date, String... pattern) {
        SimpleDateFormat sdf = null;
        if (pattern != null && pattern.length > 0) {
            sdf = new SimpleDateFormat(pattern[0]);
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return sdf.format(date);
    }

    /**
     * 用yyyy-MM-dd格式化日期
     *
     * @param date
     *
     */
    public static String formatDefault(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * 将格式化的日期字符串解析为Date类型
     *
     * @param source
     *            格式化的日期字符串
     * @param partten
     *            模式
     *
     * @throws Exception
     */
    public static Date parse(String source, String... partten) throws Exception {
        SimpleDateFormat sdf = null;
        if (partten != null && partten.length > 0) {
            sdf = new SimpleDateFormat(partten[0]);
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return sdf.parse(source);
    }

    /**
     * 跟据传进来的日期(yyyy-MM-dd)得到第二天的时间
     *
     * @param now
     *            yyyy-MM-dd
     * @throws ParseException
     */
    public static String getNextDate(String now) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(now));
        cal.add(Calendar.DATE, 1);
        return sdf.format(cal.getTime());
    }

    /**
     * 获得前一天
     *
     * @param now
     *
     * @throws ParseException
     */
    public static String getPreDate(String now) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(now));
        cal.add(Calendar.DATE, -1);
        return sdf.format(cal.getTime());
    }

    public static Date getPreDate(Date now) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 跟据传进来的日期(yyyy-MM-dd)得到第二天的时间
     *
     * @param now
     *
     * @throws ParseException
     */
    public static Date getNextDate(Date now) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     *
     * @param now
     * @param days
     *
     */
    public static Date addDays(Date now, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date addYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 日期加小时的计算
     *
     * @param date
     * @param hour
     *
     */
    public static Date addHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return cal.getTime();
    }

    /**
     * 获得处理日期
     *
     * @param date
     *            2012-03-28
     *
     * @throws ParseException
     */
    public static Date getProcessDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    /**
     * 得到两个日期相差的分钟数
     *
     */
    public static int getDateMinus(Date a, Date b) {
        if (a == null || b == null) {
            return 0;
        }
        long t1 = a.getTime();
        long t2 = b.getTime();
        return Math.round((t2 - t1) / (1000 * 60));
    }

    public static int getDateMinus(String a, String b) {
        Date ta = null;
        Date tb = null;
        try {
            ta = DateHelper.parse(a, "yyyy-MM-dd HH:mm:ss");
            tb = DateHelper.parse(b, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DateHelper.getDateMinus(ta, tb);
    }

    /**
     * 得到该日期对应的周一的日期
     *
     * @param date
     */
    public static Date getMondayDate(Date date) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, -6);
        map.put(2, 0);
        map.put(3, -1);
        map.put(4, -2);
        map.put(5, -3);
        map.put(6, -4);
        map.put(7, -5);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return DateHelper.addDays(date, map.get(cal.get(Calendar.DAY_OF_WEEK)));
    }

    /**
     * 得到时间的小时值
     *
     * @param date
     *
     */
    public static int getHours(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取不包括date在内的date之前day的天数 例如：传入2013-12-16和3，则返回[20131213,20131214,20131215]
     *
     * @param day
     * @param date
     *
     */
    public static List<String> getDatesFromto(int day, Date date) {
        List<String> dateList = new ArrayList<String>();
        while (day > 0) {
            dateList.add(format(addDays(date, -day), "yyyyMMdd"));
            day--;
        }
        return dateList;
    }

    /**
     * 获取不包括date在内的date之前day的天数 例如：传入2013-12-16和3，则返回[20131213,20131214,20131215]
     *
     * @param day
     * @param date
     * @param pattern
     *
     */
    public static List<String> getDatesFromto(int day, Date date, String pattern) {
        List<String> dateList = new ArrayList<String>();
        while (day > 0) {
            dateList.add(format(addDays(date, -day), pattern));
            day--;
        }
        return dateList;
    }

    /**
     * 得到指定的星期值
     *
     * @param date
     *
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 得到当前的星期值 星期天：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
     *
     */
    public static int getDay() {
        return getDay(new Date());
    }

    /**
     * 根据传入的月份，返回该月对应的最大日期
     *
     * @param month
     *
     */
    public static String getEndDate(String month) {
        if (month.equals("01") || month.equals("1") || month.equals("03") || month.equals("3") || month.equals("05")
                || month.equals("5") || month.equals("07") || month.equals("7") || month.equals("08")
                || month.equals("8") || month.equals("10") || month.equals("12")) {
            return "31";
        }

        if (month.equals("04") || month.equals("4") || month.equals("06") || month.equals("6") || month.equals("09")
                || month.equals("9") || month.equals("11")) {
            return "30";
        }

        return "29";
    }

    /**
     * 根据传入的年月，计算该年月之前的年月 例如传入201711,返回201710；传入201701，返回201612
     *
     * @param yyyyMm
     *
     */
    public static String getPreviousYyyyMm(String yyyyMm) {
        int yyyy = Integer.valueOf(yyyyMm.substring(0, 4));
        int month = Integer.valueOf(yyyyMm.substring(4));
        if (month == 1) {
            return "" + (yyyy - 1) + "12";
        }

        int newMonth = month - 1;
        if (newMonth < 10) {
            return "" + yyyy + "0" + newMonth;
        }
        return "" + yyyy + newMonth;
    }

    /**
     * 获取一个月中的31天
     *
     */
    public static String[] get31Days() {
        String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

        return days;
    }

    /**
     * 按照保单的有效期为1年计算的保单的结束日期
     *
     * @param beginTime
     * @return
     */
    public static String getOrderEndTimeAsOneYear(String beginTime) throws Exception {
        Date date = parse(beginTime, "yyyy-MM-dd");
        date = addYear(date, 1);
        date = addDays(date, -1);
        return format(date);
    }

    /**
     * 按照保单的有效期 计算的保单的结束日期
     *
     * @param beginTime
     * @return
     */
    public static String getOrderEndTime(String beginTime, int month) throws Exception {
        Date date = parse(beginTime, "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();// 取得六个月后时间
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.SECOND, -1);
        System.out.println(df.format(cal.getTime()));
        return df.format(cal.getTime());
    }

    /**
     * 计算年龄工具类
     *
     * @param birthDay
     * @return
     */
    public static Integer getAgeByBirth(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }
}
