package com.yzd.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/25 
 * @version : V1.0
 *
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("aaa", "bbb", "ccc");
        stringStream.forEach(System.out::println);
        IntStream.range(1, 9).forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = list.stream().map(integer -> integer * 2).reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
