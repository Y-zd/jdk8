package com.yzd.jdk8.stream.learndetail;

import com.yzd.jdk8.bean.Person;
import com.yzd.jdk8.bean.PersonGroup;

import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/9 
 * @version : V1.0
 *
 */
public class Test1 {
    public static void main(String[] args) {
        List<Person> personList = PersonGroup.generatePersons();

        List<Person> collect = personList.stream().collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println(personList.stream().collect(Collectors.counting()));
        System.out.println(personList.stream().count());


    }

}
