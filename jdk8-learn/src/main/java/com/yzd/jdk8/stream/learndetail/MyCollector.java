package com.yzd.jdk8.stream.learndetail;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/11 
 * @version : V1.0
 *
 */
public class MyCollector<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator");

        return (set, item) -> {
            System.out.println("accumulator执行线程: " + Thread.currentThread() + "set:" + set);
            set.add(item);

        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics");
        //加上 Characteristics.CONCURRENT 多个线程操作一个结果容器 不加 则多个线程操作多个结果容器再调用combiner将结果加在一起
        //return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        int[] ints = IntStream.range(1, 9).toArray();
        HashSet<String> set = new HashSet<>();
        for (int anInt : ints) {
            set.add(anInt + "");
        }
        System.out.println(set);
        Map<String, String> collect = set.stream().collect(new MyCollector<>());
        System.out.println(collect);
        System.out.println("--------------------------------");

        Map<String, String> collect2 = set.parallelStream().collect(new MyCollector<>());
        System.out.println(collect2);
        for (int i = 0; i <1000 ; i++) {
            //Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
            //加上以上会出现ConcurrentModificationException
            Map<String, String> collect3 = set.parallelStream().collect(new MyCollector<>());
        }

    }
}
