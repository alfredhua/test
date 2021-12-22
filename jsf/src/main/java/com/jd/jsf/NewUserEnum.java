package com.jd.jsf;

import org.msgpack.annotation.MessagePackOrdinalEnum;

@MessagePackOrdinalEnum
public enum NewUserEnum {


    user_0("desc0","0","name0"),
    user_1("desc1","1","name1"),
    user_2("desc2","2","name2"),
    ;

    private String desc;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String code;
    private String name;


    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    NewUserEnum(String desc, String code, String name){
        this.desc = desc;
        this.code= code;
        this.name= name;
    }
}
