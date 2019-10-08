package com.yzd.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/8 
 * @version : V1.0
 *
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "ccc", "bbb");
        list.stream().map(String::toUpperCase).forEach(System.out::println);


        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4));
        List<Integer> collect = lists.stream().flatMap(theList -> theList.stream().map(i -> i * i)).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }
}
