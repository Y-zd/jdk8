package com.yzd.design_pattern.mine;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class Ham extends Food {
    @Override
    public String getDescription() {
        return "火腿";
    }

    @Override
    public int cost() {
        return 1;
    }
}
