package com.yzd.jdk8.lamdainterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 *
 * @author : yanzhidong
 * @date : 2019/9/18 
 * @version : V1.0
 *
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        Collections.sort(list, String::compareTo);


    }
}
