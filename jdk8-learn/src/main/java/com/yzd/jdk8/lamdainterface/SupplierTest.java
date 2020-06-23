package com.yzd.jdk8.lamdainterface;

import com.yzd.jdk8.bean.Person;

import java.util.function.Supplier;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/19 
 * @version : V1.0
 *
 */
public class SupplierTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(1);
        System.out.println(person);

        Supplier<Person> supplier =()->new Person();
        Person person1 = supplier.get();
        person1.setAge(2);
        System.out.println(person1);

        Supplier<Person> supplier2 = Person::new;
        Person person2 = supplier2.get();
        person2.setAge(3);
        System.out.println(person2);

    }
}
