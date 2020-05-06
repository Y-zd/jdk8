package com.yzd.jdk8.stream;

import com.yzd.jdk8.bean.Person;
import com.yzd.jdk8.bean.PersonGroup;

import java.util.*;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/9 
 * @version : V1.0
 *
 * 分组分区
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("张三", "李四", "王五", "赵六");

        list1.stream()
                .flatMap(item -> list2.stream().map(item2 -> item + " " + item2))
                .forEach(System.out::println);
        System.out.println("----------------------------------");

        List<Person> personList = PersonGroup.generatePersons();

        Map<Boolean, List<Person>> collect = personList.stream()
                .collect(Collectors.groupingBy(item -> item.getScore() > 80));
        System.out.println(collect);

        Map<String, Long> collect1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        System.out.println(collect1);

        Map<String, Double> collect2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println(collect2);

        //分区
        Map<Boolean, List<Person>> collect3 = personList.stream()
                .collect(Collectors.partitioningBy(item -> item.getScore() > 90));
        System.out.println(collect3);
        System.out.println("----------------------------------");
        //找出分数最低
        Optional<Person> collect4 = personList.stream().collect(Collectors.minBy(Comparator.comparing(Person::getScore)));
        System.out.println(collect4);
        //求分数的总合
        IntSummaryStatistics collect5 = personList.stream().collect(Collectors.summarizingInt(Person::getScore));
        System.out.println(collect5);
        System.out.println("----------------------------------");

        //字符串拼接
        System.out.println(personList.stream().map(Person::getName).collect(Collectors.joining()));
        System.out.println(personList.stream().map(Person::getName).collect(Collectors.joining(",")));
        System.out.println(personList.stream().map(Person::getName).collect(Collectors.joining(",", "《", "》")));
        System.out.println("----------------------------------");

        //多级分组
        Map<Integer, Map<String, List<Person>>> collect6 = personList.stream()
                .collect(Collectors.groupingBy(Person::getScore, Collectors.groupingBy(Person::getName)));
        System.out.println(collect6);

        //多级分区
        Map<Boolean, Map<Boolean, List<Person>>> collect7 = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getScore() > 80, Collectors.partitioningBy((person2 -> person2.getScore() > 80))));
        System.out.println(collect7);

        //获取每一组的最小分数
        Map<Integer, Optional<Person>> collect8 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.minBy(Comparator.comparing(Person::getScore))));
        System.out.println(collect8);

        //排序map
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1, 1);
        testMap.put(3, 1);
        testMap.put(5, 2);
        testMap.put(2, 10);
        testMap.put(10, 0);
        testMap.put(10, 2);
        Map<Integer, Integer> sortedMap = new HashMap<>();

        testMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .sorted(Map.Entry.comparingByKey()).forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
        sortedMap.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));


    }

}
