package com.yzd.jdk8.lamdainterface;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/16
 * @version : V1.0
 *
 */


@FunctionalInterface
interface Test1Interface {
    void run();
}

public class Test1 {

    public void myTest(Test1Interface myInterface) {
        System.out.println(1);
        myInterface.run();
        System.out.println(2);

    }


    public static void main(String[] args) {
        Test1 test = new Test1();
        test.myTest(() -> System.out.println("..."));
        Test1Interface myInterface = () -> System.out.println(3);
        List<Integer> list = new ArrayList<>();
        list.forEach(i -> System.out.println(i));
        list.forEach(System.out::println);
    }
}
