package com.yzd.jdk8.lamdainterface;

import com.yzd.jdk8.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/18 
 * @version : V1.0
 *
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        System.out.println(compute(1, value -> value + 1, value -> value * 2));
        System.out.println(compute2(1, value -> value + 1, value -> value * 2));
        System.out.println(compute3(1, 2, (a, b) -> a * b));
        System.out.println(compute4(1, 2, (a, b) -> a * b, value -> value - 2));


        Person person1 = new Person().setName("aaa").setAge(30);
        Person person2 = new Person().setName("bbb").setAge(20);
        Person person3 = new Person().setName("ccc").setAge(10);
        List<Person> list = Arrays.asList(person1, person2, person3);
        System.out.println(list);
        List<Person> collect = list.stream().filter(person -> person.getAge() > 10).collect(Collectors.toList());
        System.out.println(collect);
        List<Person> collect2 = list.stream().filter(person -> person.getName().equals("aaa")).collect(Collectors.toList());
        System.out.println(collect2);
        List<Person> choseList = choseList(list, person -> person.getName().equals("ccc"));
        System.out.println(choseList);
    }

    /**
     * Function 接口测试
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public static int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    /**
     * Function 接口测试
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    /**
     * BiFunction 接口测试
     *
     * @param a
     * @param b
     * @param biFunction
     * @return
     */
    public static int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    /**
     * BiFunction 接口测试
     *
     * @param a
     * @param b
     * @param biFunction1
     * @param Function
     * @return
     */
    public static int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction1, Function<Integer, Integer> Function) {
        return biFunction1.andThen(Function).apply(a, b);
    }

    /**
     * Predicate 接口测试
     *
     * @param list
     * @param predicate
     * @return
     */
    public static List<Person> choseList(List<Person> list, Predicate<Person> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }


}
