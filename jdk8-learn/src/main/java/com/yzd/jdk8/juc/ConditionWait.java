package com.yzd.jdk8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class ConditionWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("begin - ConditionWait");
            condition.await();//阻塞 类似于synchronize 中的wait
            System.out.println("end - ConditionWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
