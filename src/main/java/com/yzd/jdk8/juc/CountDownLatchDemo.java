package com.yzd.jdk8.juc;

import java.util.concurrent.CountDownLatch;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("thread1");
            countDownLatch.countDown();//3-1=2
        }).start();

        new Thread(() -> {
            System.out.println("thread2");
            countDownLatch.countDown();//3-2=1
        }).start();
        new Thread(() -> {
            System.out.println("thread3");
            countDownLatch.countDown();//1-1=0
        }).start();
        try {
            countDownLatch.await();//如果count没减到0 不往后执行
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println(1231231);
            e.printStackTrace();
            System.out.println(00000);
        }
        System.out.println(2222);
    }
}
