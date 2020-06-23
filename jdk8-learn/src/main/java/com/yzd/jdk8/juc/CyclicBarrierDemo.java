package com.yzd.jdk8.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/***
 *当存在需要所有的子任务都完成时，才执行主任务，这个
 * 时候就可以选择使用 CyclicBarrier
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class CyclicBarrierDemo extends Thread {

    private CyclicBarrier cyclicBarrier;
    private String path;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println(" 开始导入：" + path + "位置的数据");
        try {
            cyclicBarrier.await();//阻塞
        } catch
        (InterruptedException e) {
            e.printStackTrace();
        } catch
        (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
