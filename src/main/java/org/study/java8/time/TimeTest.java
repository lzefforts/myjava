package org.study.java8.time;

import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ArnoldLee on 18/9/26.
 */
public class TimeTest {


    public static void main(String[] args) {
        //获取当前的年月日
        LocalDate localDate =LocalDate.now();
        System.out.println(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());

        //获取当前的时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = localTime.plusMinutes(30);
        System.out.println(localTime);

        //获取当前的 年月日 时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String nowTimeStr = formatter.format(localDateTime);
        System.out.println(nowTimeStr);

        localDateTime.minusDays(30);


//        localDateTime = localDateTime.plusMinutes(30);
//        System.out.println(formatter.format(localDateTime));


//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse("2018-11-13 12:30:55",formatter );
//        localDateTime = localDateTime.plusMinutes(30);
//        System.out.println(formatter.format(localDateTime));


//        DateTime dateTime = new DateTime();
//        System.out.println(dateTime);

    }

}
