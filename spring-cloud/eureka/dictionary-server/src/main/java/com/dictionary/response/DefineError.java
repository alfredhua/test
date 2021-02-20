package com.dictionary.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DefineError implements Serializable {

     String msg;
     String name;

    public DefineError() {
    }

    public DefineError(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

}
