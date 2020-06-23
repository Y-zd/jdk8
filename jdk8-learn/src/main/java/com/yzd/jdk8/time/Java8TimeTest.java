package com.yzd.jdk8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/23 
 * @version : V1.0
 *
 */
public class Java8TimeTest {

    public static void main(String[] args) {

        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        System.out.println(localDate1.getYear() + "," +
                localDate1.getMonthValue() + "," +
                localDate1.getDayOfMonth());
        System.out.println("----------------");
        LocalDate localDate2 = LocalDate.of(2019, 10, 23);
        System.out.println(localDate2);
        System.out.println("----------------");
        MonthDay from = MonthDay.from(LocalDate.of(2019, 11, 23));
        System.out.println(from);
        System.out.println("----------------");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.minusHours(1));
        System.out.println("----------------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("----------------");
        System.out.println(ZoneId.getAvailableZoneIds());

        System.out.println("----------------");
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(LocalDateTime.now().format(ofPattern));

        System.out.println("----------------");
        System.out.println(toDate(LocalDateTime.now()));
        System.out.println(toLocalDateTime(new Date()));
    }

    /**
     * LocalDateTime -> Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * Date -> LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }
}
