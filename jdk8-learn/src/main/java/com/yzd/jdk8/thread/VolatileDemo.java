package com.yzd.jdk8.thread;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/22 
 * @version : V1.0
 *
 */
public class VolatileDemo {
    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}