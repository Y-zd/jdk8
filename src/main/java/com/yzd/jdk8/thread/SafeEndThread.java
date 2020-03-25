package com.yzd.jdk8.thread;

/***
 *
 * @author : yanzhidong
 * @date : 2020/2/24 
 * @version : V1.0
 *
 */
public class SafeEndThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + "running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("flag = " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + "is end ,flag = " + Thread.currentThread().isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        SafeEndThread safeEndThread = new SafeEndThread();
        Thread t2 = new Thread(safeEndThread);
        t2.start();
        Thread.sleep(1);
        t2.interrupt();
    }
}
