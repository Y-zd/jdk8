package com.yzd.jdk8.gc;

/***
 * https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
 * @author : yanzhidong
 * @date : 2020/5/11 
 * @version : V1.0
 *
 */
public class StringPoolTest {

    public static void main(String[] args) {
        fun1();
        fun2();
    }


    /**
     * jdk6 下false false
     * jdk7 下false true
     */
    static void fun1() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    /**
     * jdk6 下false false
     * jdk7 下false false
     */
    public static void fun2() {
        String s = new String("2");
        String s2 = "2";
        s.intern();
        System.out.println(s == s2);
        String s3 = new String("2") + new String("2");
        String s4 = "22";
        s3.intern();
        System.out.println(s3 == s4);
    }


}
