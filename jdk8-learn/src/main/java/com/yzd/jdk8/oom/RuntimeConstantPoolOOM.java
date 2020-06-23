package com.yzd.jdk8.oom;

import java.util.ArrayList;
import java.util.List;

/***
 * 运行时常量池导致的内存溢出 OutOfMemoryError: Metaspace元空间
 * -XX:PermSize=10M  Perm永久代，java8已经被Metaspace代替
 * -XX:MaxPermSize=10M
 * -XX:MetaspaceSize=1m
 * -XX:MaxMetaspaceSize=1m
 * @author : yanzhidong
 * @date : 2020/1/7 
 * @version : V1.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
