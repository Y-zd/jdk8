package com.yzd.design_pattern.mine;

/***
 *
 * @author : yanzhidong
 * @date : 2020/9/7 
 * @version : V1.0
 *
 */
public class Main {

    public static void main(String[] args) {

        JianBin jianBin = new JianBin(new Egg());
        BaoZi baoZi = new BaoZi(jianBin);
        System.out.println(baoZi.getDescription());
        System.out.println(baoZi.cost());


    }

}
