package com.desgin.openClose;

public class OffJavaCourse extends JavaCourse {

    public OffJavaCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.5 ;
    }
}
