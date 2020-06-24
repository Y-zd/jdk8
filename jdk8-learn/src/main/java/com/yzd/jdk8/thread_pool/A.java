package com.yzd.jdk8.thread_pool;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/24 
 * @version : V1.0
 *
 */
class A {
    @Override protected void finalize() {
        System.out.println(this + " was finalized!");
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        System.out.println("Created " + a);
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_00 == 0)
                System.gc();
        }
        System.out.println("done.");
    }
}
