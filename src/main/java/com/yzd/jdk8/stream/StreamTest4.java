package com.yzd.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/8 
 * @version : V1.0
 *
 */
public class StreamTest4 {

    public static void main(String[] args) {

        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        generate.findFirst().ifPresent(System.out::println);
        System.out.println("--------------------------------------------");

        Stream.iterate(1,integer -> integer+1).limit(6).forEach(System.out::println);
        System.out.println("--------------------------------------------");

        //mapToInt可以防止自动装箱拆箱
        System.out.println(
                Stream.iterate(1, integer -> integer + 2)
                        .limit(6)
                        .filter(i -> i > 2)
                        .mapToInt(i -> i * 2)
                        .skip(2).limit(2).sum());


                Stream.iterate(1, integer -> integer + 2)
                        .limit(6)
                        .filter(i -> i > 2)
                        .mapToInt(i -> i * 2)
                        .skip(2).limit(2).min().ifPresent(System.out::println);

        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, integer -> integer + 2)
                .limit(6)
                .filter(i -> i > 2)
                .mapToInt(i -> i * 2)
                .skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics);


    }
}
