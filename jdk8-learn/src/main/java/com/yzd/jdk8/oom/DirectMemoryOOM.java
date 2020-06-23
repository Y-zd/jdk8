package com.yzd.jdk8.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/***
 *  本机直接内存溢出
 *  -Xmx20M
 *  -XX:MaxDirectMemorySize=10M 最大堆外内存，主要是针对DirectByteBuffer对象关联的内存，
 *                              默认和堆最大内存(Xmx)一样
 * @author : yanzhidong
 * @date : 2020/1/7 
 * @version : V1.0
 *
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
