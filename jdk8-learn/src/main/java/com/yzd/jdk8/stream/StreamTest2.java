package com.yzd.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/8 
 * @version : V1.0
 *
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloWorld");
//        String[] array = stream.toArray(String[]::new);
//        Arrays.asList(array).forEach(System.out::println);

//        List<String> collect = stream.collect(Collectors.toList());

//        List<String> collect=  stream.collect(
//               ()->new ArrayList<>(),
//               (list1,item)->list1.add(item),
//               (list2,list3)->list2.addAll(list3));
//        collect.forEach(System.out::println);


        TreeSet<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));
        collect.stream().forEach(System.out::println);


    }
}
