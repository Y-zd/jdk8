package com.yzd.jdk8.bean;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/19 
 * @version : V1.0
 *
 */
public class Person {

    private String name;

    private int age;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
