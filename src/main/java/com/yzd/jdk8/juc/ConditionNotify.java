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
public class ConditionNotify implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("begin - ConditionNotify");
        condition.signal();//唤醒阻塞状态的线程 类似于synchronize 中的notify
        System.out.println("end - ConditionNotify");
        lock.unlock();
    }
}
