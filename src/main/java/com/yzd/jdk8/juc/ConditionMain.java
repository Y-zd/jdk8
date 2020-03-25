package com.yzd.jdk8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *  Condition的作用类似与synchronize中的wait/notify
 * @author : yanzhidong
 * @date : 2020/3/25 
 * @version : V1.0
 *
 */
public class ConditionMain {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionWait(lock, condition)).start();
        new Thread(new ConditionNotify(lock, condition)).start();

    }


}
