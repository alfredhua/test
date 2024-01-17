package com.jd.jsf;

import org.msgpack.annotation.MessagePackOrdinalEnum;

@MessagePackOrdinalEnum
public enum OldUserEnum {

    user_1("1","name1"),
    user_2("2","name2"),
    ;

    private String code;
    private String name;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    OldUserEnum(String code, String name){
        this.code= code;
        this.name= name;
    }
}
