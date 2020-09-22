package com.yzd.design_pattern.decoration;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class BlackTea extends Beverage {
    @Override
    public String getDescription() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 10L;
    }
}
