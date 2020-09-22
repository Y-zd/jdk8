package com.yzd.design_pattern.decoration;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class Mongo extends Condiment {
    private Beverage bevarage;

    public Mongo(Beverage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    public String getDescription() {
        return bevarage.getDescription() + ", 加芒果";
    }

    @Override
    public double cost() {
        return bevarage.cost() + 3; // 加芒果需要 3 元
    }
}