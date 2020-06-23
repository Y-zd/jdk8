package com.yzd.jdk8.oom;

/***
 * 栈 OutOfMemoryError: unable to create new native thread heap
 * ps:谨慎执行该方法会，windows平台会gg
 * -Xss2M
 * @author : yanzhidong
 * @date : 2020/1/7 
 * @version : V1.0
 *
 */
public class VMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        VMStackOOM oom = new VMStackOOM();
        oom.stackLeakByThread();
    }
}
