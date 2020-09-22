package com.yzd.design_pattern.mine;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class Egg extends Food {
    @Override
    public String getDescription() {
        return "鸡蛋";
    }

    @Override
    public int cost() {
        return 1;
    }
}
