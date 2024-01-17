package com.es.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by guozhenhua
 * date 2020/6/18.
 */
@Scope("prototype")
@Component
public class PersonDao {

    public String test(){
        return "test";
    }
}
