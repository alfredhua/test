package com.jd.jsf;

import com.alibaba.fastjson.JSON;
import org.msgpack.MessagePack;

import java.io.IOException;

public class MsgPackTest {

    public static void main(String[] args) throws IOException {


        OldUser oldUser = new OldUser();
        oldUser.setUserName("name");
        oldUser.setDesc("desc");
        System.out.println("user 序列化前："+JSON.toJSON(oldUser));
        MessagePack messagePack = new MessagePack();
        byte[] bytes = messagePack.write(oldUser);
        NewUser newUser = messagePack.read(bytes, NewUser.class);
        System.out.println("user 序列化后重新反序列化："+ JSON.toJSON(newUser));

        System.out.println("--------------------------------------------");

        // -----------------------------------------
        OldUserEnum oldUserEnum = OldUserEnum.user_1;
        System.out.println("userEnum 枚举序列化前："+JSON.toJSONString(oldUserEnum));
        byte[] enumBytes = messagePack.write(oldUserEnum);
        NewUserEnum newUserEnum = messagePack.read(enumBytes, NewUserEnum.class);
        System.out.println("userEnum 序列化后反序列化："+JSON.toJSONString(newUserEnum));
    }
}
