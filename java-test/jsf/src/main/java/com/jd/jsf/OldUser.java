package com.jd.jsf;

import lombok.Data;
import org.msgpack.annotation.Message;

@Data
@Message
public class OldUser {

    private String userName;

    private String desc;
}
