package com.yzd.jdk8.lamdainterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/20 
 * @version : V1.0
 *
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a","d","c");
        Collections.sort(list,String::compareTo);
        System.out.println(list);
    }

}
