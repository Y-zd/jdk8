package com.yzd.jdk8.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/23 
 * @version : V1.0
 *
 */
public class JodaTimeTest {


    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println(today.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));
        System.out.println(today.withDayOfMonth(1).toString("yyyy-MM-dd"));
        System.out.println("------------------------");
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        System.out.println(localDate.plusMonths(1).dayOfMonth().withMaximumValue());
        System.out.println("------------------------");
        System.out.println(UTC2Date("2019-11-04T09:22:22.123z"));
        System.out.println(Date2UTC(new Date()));

    }



    /**
     * 标准UTC时间格式：2019-11-04T09:22:22.123Z
     * @param utcDate
     * @return
     */
    public static Date UTC2Date(String utcDate) {
        DateTime parse = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return parse.toDate();
    }

    public static String Date2UTC(Date date) {
        DateTime dateTime = new DateTime(date, DateTimeZone.UTC);
        return dateTime.toString();
    }
}


