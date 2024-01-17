package com.desgin.stargy;

public class OtherPayStrategy implements IStrategy{
    @Override
    public void pay() {
        System.out.println("其它支付渠道");
    }
}
