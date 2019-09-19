package com.yzd.jdk8.lamdainterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/16 
 * @version : V1.0
 *
 */

@FunctionalInterface
interface Test2Interface1 {
    void method();
}

@FunctionalInterface
interface Test2Interface2 {
    void method();
}

public class Test2 {
    public static void main(String[] args) {
        Test2Interface1 interface1 = () -> {
        };
        Test2Interface2 interface2 = () -> {
        };
        System.out.println(interface1.getClass().getInterfaces()[0]);
        System.out.println(interface2.getClass().getInterfaces()[0]);
        new Thread(() -> System.out.println(111)).start();


        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        Function<String, String> function = String::toString;


    }
}
