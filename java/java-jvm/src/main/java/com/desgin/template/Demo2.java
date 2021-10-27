package com.desgin.template;

public class Demo2 extends ITemplate {
    @Override
    void first() {
        System.out.println("demo2 执行 first");
    }

    @Override
    void second() {
        System.out.println("demo2 执行 second");
    }

    @Override
    void three() {
        System.out.println("demo2 执行 three");
    }
}
