package com.yzd.jdk8.juc;

import java.util.concurrent.Semaphore;

/***
 *  可用于限流
 *  底层还是aqs
 *  有公平和非公平
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class SemaphoreDemo {

    static class Car extends Thread {

        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();//获得一个令牌，如果拿不到令牌就会阻塞
                System.out.println("第" + num + "辆车抢占一个车位");
                Thread.sleep(2000);
                System.out.println("第" + num + "辆车开走了");
                semaphore.release();//释放令牌
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i < 6; i++) {
            new Car(i, semaphore).start();
        }
    }

}
