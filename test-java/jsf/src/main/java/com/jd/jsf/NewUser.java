package com.jd.jsf;

import lombok.Data;
import org.msgpack.annotation.Message;

@Data
@Message
public class NewUser {

    private String newFiled;

    private String userName;

    private String desc;
}
