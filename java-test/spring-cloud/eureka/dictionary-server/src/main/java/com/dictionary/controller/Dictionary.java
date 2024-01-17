package com.dictionary.controller;

import com.dictionary.response.ListAuthDictionaryResponse;
import com.dictionary.service.impl.AuthDictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth guozhenhua
 * @date 2018/11/22
 */
@RestController
public class Dictionary {


    @Autowired
    AuthDictionaryServiceImpl authDictionaryServiceImpl;


    @RequestMapping(value = "listAuthDictionary")
    public ListAuthDictionaryResponse listAuthDictionary(){
        return  authDictionaryServiceImpl.listAuthDictionary(1, 1, 10);
    }


}
