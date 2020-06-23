package com.yzd.jdk8.oom;

/***
 *  栈溢出 StackOverflowError
 * -Xss128k 线程栈的大小，默认1M
 * @author : yanzhidong
 * @date : 2020/1/7 
 * @version : V1.0
 */
public class VMStackOFE {
    public int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        VMStackOFE stackOFE = new VMStackOFE();
        try {
            stackOFE.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + stackOFE.stackLength);
            throw e;
        }
    }
}
