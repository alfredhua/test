package com.desgin.stargy;

public class ZfbPayStrategy implements IStrategy{
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
