package com.yzd.jdk8.gc;

import java.util.UUID;

/***
 * http://lovestblog.cn/blog/2016/11/06/string-intern/
 * -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -Xmx2G -Xms2G -Xmn100M
 *
 * -XX:+PrintStringTableStatistics(JVM 才会将统计数据打印出来)
 * @author : yanzhidong
 * @date : 2020/5/9 
 * @version : V1.0
 *
 */

public class StringTableTest {
    public static void main(String args[]) {
        for (int i = 0; i < 10000000; i++) {
            uuid();
        }
    }



    public static void uuid() {
        UUID.randomUUID().toString().intern();
    }
}