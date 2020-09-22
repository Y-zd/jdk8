package com.yzd.design_pattern.decoration;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class Lemon extends Condiment {
    private Beverage bevarage;

    // 这里很关键，需要传入具体的饮料，如需要传入没有被装饰的红茶或绿茶，
    // 当然也可以传入已经装饰好的芒果绿茶，这样可以做芒果柠檬绿茶
    public Lemon(Beverage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    public String getDescription() {
        return bevarage.getDescription() + ",加柠檬";
    }

    @Override
    public double cost() {
        return bevarage.cost() + 2L;
    }
}
