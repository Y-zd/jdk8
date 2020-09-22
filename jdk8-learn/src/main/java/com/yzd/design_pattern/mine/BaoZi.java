package com.yzd.design_pattern.mine;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class BaoZi extends Seasoning {
    private Food food;

    public BaoZi(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "包子" + ",加" + food.getDescription();
    }

    @Override
    public int cost() {
        return 1 + food.cost();
    }
}
