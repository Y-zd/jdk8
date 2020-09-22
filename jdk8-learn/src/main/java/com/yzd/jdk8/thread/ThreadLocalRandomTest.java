package com.yzd.jdk8.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/30 
 * @version : V1.0
 *
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        final int index = ThreadLocalRandom.current().nextInt(1, 100);
        AtomicInteger lastIndex = new AtomicInteger(0);
        System.out.println(lastIndex);
        List<String> listStr=new ArrayList<>();
        listStr.add("70");
        listStr.add("100");
        List<Integer> listInt = listStr
                .stream()
                .map(str -> {
                    lastIndex.addAndGet(Integer.parseInt(str));
                    if (lastIndex.get() > index) {
                        return Integer.parseInt(str);
                    }
                    return null;
                })
                .filter(Objects::nonNull).collect(Collectors.toList());


        Integer a = listInt.get(0);
        System.out.println(a);
            int min=100;
            int max=200;
        int i = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println(i);

    }
}
