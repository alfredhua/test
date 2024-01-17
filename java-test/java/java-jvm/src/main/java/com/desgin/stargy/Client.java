package com.desgin.stargy;

public class Client {

    public static void main(String[] args) {
        new Context(new OtherPayStrategy()).executeStrategy();
        new Context(new ZfbPayStrategy()).executeStrategy();
        new Context(new WeChartPayStrategy()).executeStrategy();
    }

}
