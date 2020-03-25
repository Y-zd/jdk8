package com.yzd.jdk8.juc;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
import java.util.concurrent.CountDownLatch;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/25
 * @version : V1.0
 *
 */
public class CountDownLatchDemo2 extends Thread {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getId());
            countDownLatch.await();
            System.out.println(Thread.currentThread().getId() + "end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            new CountDownLatchDemo2().start();
        }
        countDownLatch.countDown();
    }
}
