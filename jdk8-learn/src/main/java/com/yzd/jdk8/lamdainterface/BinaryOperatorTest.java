package com.yzd.jdk8.lamdainterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/19 
 * @version : V1.0
 *
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {

        System.out.println(comparat(1,2,(a,b)->a-b));
    }

    public static int comparat(int a, int b, Comparator<Integer> comparator) {
        return BinaryOperator.maxBy(comparator).apply(a, b);
    }
}
