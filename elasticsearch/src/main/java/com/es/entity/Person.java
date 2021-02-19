package com.es.entity;


import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author guozhenhua
 * @date 2020/03/29
 */

@Document(indexName = "person", type = "person")
public class Person {

    Long id;


    String name;

    String text;

    short sex;

    String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public short getSex() {
        return sex;
    }

    public void setSex(short sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
