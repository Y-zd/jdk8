package com.yzd.jdk8.lamdainterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/19 
 * @version : V1.0
 *
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        comditionFilter(list, integer -> integer % 2 == 0);
        comditionFilter2(list,integer -> integer % 2 == 0,integer -> integer >5);

        for (Integer integer : list) {

            boolean test = Predicate.isEqual(integer).test("123");
            System.out.println(test);
        }

    }

    public static void comditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }


    /**
     * 逻辑与
     * @param list
     * @param predicate1
     * @param predicate2
     */
    public static void comditionFilter2(List<Integer> list, Predicate<Integer> predicate1,Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate1.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }

}
