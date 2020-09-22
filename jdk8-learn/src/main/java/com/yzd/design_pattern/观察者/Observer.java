package com.yzd.design_pattern.观察者;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}