package com.yzd.jdk8.lamdainterface;

import java.util.function.Function;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/18 
 * @version : V1.0
 *
 */
public class FunctionTest {


    public static void main(String[] args) {
        System.out.println(compute(4, value -> value * 2));
        System.out.println(compute(4, value -> value + 2));
        System.out.println(compute(4, value -> value / 2));
        Function<Integer, Integer> function = value -> value + 1;
        System.out.println(compute(4, function));

    }


    public static int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }


}
