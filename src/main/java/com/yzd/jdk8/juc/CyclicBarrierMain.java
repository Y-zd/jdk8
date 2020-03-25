package com.yzd.jdk8.juc;

import java.util.concurrent.CyclicBarrier;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class CyclicBarrierMain extends Thread {
    @Override
    public void run() {
        System.out.println(" 开始进行数据分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cycliBarrier = new CyclicBarrier(3, new CyclicBarrierMain());
        new Thread(new CyclicBarrierDemo(cycliBarrier, "file1")).start();
        new Thread(new CyclicBarrierDemo(cycliBarrier, "file 2")).start();
        new Thread(new CyclicBarrierDemo(cycliBarrier, "file 3")).start();
    }

}
