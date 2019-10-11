package com.yzd.jdk8.stream;

import com.yzd.jdk8.bean.Person;
import com.yzd.jdk8.bean.PersonGroup;

import java.util.Arrays;
import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/9 
 * @version : V1.0
 *
 */
public class StreamTest6 {
    public static void main(String[] args) {

        List<Person> personList = PersonGroup.generatePersons();

        personList.stream().filter(person -> person.getAge() > 18)
                .filter(person -> "张三".equals(person.getName()))
                .forEach(System.out::println);
        System.out.println("----------------------------------");


        personList.stream().filter(person ->
        {
            System.out.println(person);
            return person.getAge()>19;
        }).findFirst().ifPresent(System.out::println);
        System.out.println("----------------------------------");


        List<String> list = Arrays.asList("a", "a b", "a b c");
        list.stream().map(item->item.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .distinct().forEach(System.out::println);
        System.out.println("----------------------------------");


    }

}
