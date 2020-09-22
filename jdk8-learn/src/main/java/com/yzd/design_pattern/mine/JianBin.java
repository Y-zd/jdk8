package com.yzd.design_pattern.mine;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class JianBin extends Seasoning {

    private Food food;

    public JianBin(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "煎饼" + ",加" + food.getDescription();
    }

    @Override
    public int cost() {
        return 1 + food.cost();
    }
}
