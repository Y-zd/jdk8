package com.yzd.jdk8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

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

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }
}
