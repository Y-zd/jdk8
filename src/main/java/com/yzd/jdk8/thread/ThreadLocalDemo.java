package com.yzd.jdk8.thread;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/27 
 * @version : V1.0
 *
 */
public class ThreadLocalDemo {

    static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static ThreadLocal<String> str = ThreadLocal.withInitial(()->"aaa");

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(() -> {
                Integer integer = num.get();
                integer += 5;
                num.set(integer);
                str.set(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + ":" + num.get()+":"+str.get());
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }


}
