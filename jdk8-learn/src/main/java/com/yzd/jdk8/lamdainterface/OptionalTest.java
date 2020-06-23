package com.yzd.jdk8.lamdainterface;

import com.yzd.jdk8.bean.Person;
import com.yzd.jdk8.bean.PersonGroup;

import java.util.*;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/20 
 * @version : V1.0
 *
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("aaaa");
        optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("bbb"));

        PersonGroup personGroup = new PersonGroup();
        personGroup.setName("A");
        Person person = new Person().setName("a");
        List<Person> list = Collections.singletonList(person);
//        personGroup.setPersons(list);


        Optional<PersonGroup> optionalPersonGroup = Optional.ofNullable(personGroup);
        Optional<List<Person>> optionalPeople = optionalPersonGroup.map(personGroup1 -> personGroup.getPersons());
        System.out.println(optionalPeople.orElse(Collections.emptyList()));


    }
}
