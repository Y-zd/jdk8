package com.yzd.design_pattern.decoration;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public abstract class Beverage {

    // 返回描述
    public abstract String getDescription();

    // 返回价格
    public abstract double cost();
}
