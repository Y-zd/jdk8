package com.yzd.jdk8.oom;

import java.util.ArrayList;
import java.util.List;

/***
 * 堆内存 OutOfMemoryError: Java heap space
 * -Xms20m 初始堆大小（字节）
 * -Xmx20m 最大堆大小（以字节为单位）
 * -XX:+HeapDumpOnOutOfMemoryError 抛出java.lang.OutOfMemoryError时将堆转储到文件
 * -XX:HeapDumpPath=D:/test/jvm/heap.dump OutOfMemoryError时转储文件的路径（文件名或目录）
 * @author : yanzhidong
 * @date : 2020/1/7 
 * @version : V1.0
 *
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
