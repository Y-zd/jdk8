package com.yzd.jdk8.stream;

import java.util.stream.IntStream;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/9 
 * @version : V1.0
 *
 */
public class StreamTest5 {
    public static void main(String[] args) {
        //以下会产生无限流
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);

        //以下不会产生无限流
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);

    }
}
