package com.yzd.jdk8.jdkproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 *
 * @author : yanzhidong
 * @date : 2020/3/12 
 * @version : V1.0
 *
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        try {

            Person instance = (Person)new JdkProxy().getInstance(new Boy());
            instance.run();

            //$Proxy0
//            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//            FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
//            os.write(bytes);
//            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
