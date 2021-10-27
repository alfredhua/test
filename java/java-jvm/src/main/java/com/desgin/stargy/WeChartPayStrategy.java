package com.desgin.stargy;

public class WeChartPayStrategy implements IStrategy{
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
