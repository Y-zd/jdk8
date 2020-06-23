package com.yzd.jdk8.juc;

import java.util.concurrent.ArrayBlockingQueue;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/26 
 * @version : V1.0
 *
 */
public class BlockingDemo {
    ArrayBlockingQueue<String> ab = new ArrayBlockingQueue(10);

    {
        init();
    }

    public void init() {
        new Thread(() -> {
          while (true){
            try {
                String data = ab.take();//阻塞方式活动数据
                System.out.println("接收：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          }
        }).start();
    }

    public void addData(String data) {
        ab.add(data);
        System.out.println("add：" + data);
         try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingDemo blockingDemo = new BlockingDemo();
        for (int i = 0; i < 1000; i++) {
            blockingDemo.addData("data" + i);
        }

    }

}
