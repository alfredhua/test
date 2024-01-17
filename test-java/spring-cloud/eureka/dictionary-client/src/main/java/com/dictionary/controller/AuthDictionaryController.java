package com.dictionary.controller;
import com.dictionary.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author hua
 *
 */
@RestController
public class AuthDictionaryController extends  BackBaseController{

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = Url.listAuthDictionary)
    public String listAuthDictionary(){
        String forObject = restTemplate.getForObject("http://dictionary-server/listAuthDictionary", String.class);
        System.out.println(forObject);
        return  forObject;
    }

    @RequestMapping(value = Url.createAuthDictionary)
    public String createAuthDictionary(){
        return  null;
    }

    @RequestMapping(value = Url.editAuthDictionary)
    public String editAuthDictionary(){
        return  null;
    }

    @RequestMapping(value = Url.delAuthDictionary)
    public String delAuthDictionary(Integer id){
        return  null;
    }


}
