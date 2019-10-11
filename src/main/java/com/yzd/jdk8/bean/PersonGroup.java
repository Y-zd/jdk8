package com.yzd.jdk8.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/20 
 * @version : V1.0
 *
 */
@Data
@Accessors(chain = true)
public class PersonGroup {

    private String name;
    private List<Person> persons;

    public static List<Person> generatePersons() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person().setName("张三").setAge(17).setScore(80));
        personList.add(new Person().setName("李四").setAge(17).setScore(70));
        personList.add(new Person().setName("王五").setAge(20).setScore(90));
        personList.add(new Person().setName("赵六").setAge(19).setScore(95));
        return personList;
    }

}
