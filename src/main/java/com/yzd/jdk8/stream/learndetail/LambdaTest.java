package com.yzd.jdk8.stream.learndetail;

/***
 *
 * @author : yanzhidong
 * @date : 2019/10/22 
 * @version : V1.0
 *
 */
public class LambdaTest {

    //Lambda并不是内部类的语法糖
    Runnable r1 = () -> System.out.println("r1:"+this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("r2:"+this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        System.out.println(lambdaTest);
        Thread t1 = new Thread(lambdaTest.r1);
        t1.run();
        System.out.println("----------------------");
        Thread t2 = new Thread(lambdaTest.r2);
        t2.run();
    }

}
