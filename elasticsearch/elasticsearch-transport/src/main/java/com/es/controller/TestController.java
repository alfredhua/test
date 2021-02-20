package com.es.controller;

import com.es.entity.Person;
import com.es.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guozhenhua
 * @date 2020/03/29
 */
@RestController
public class TestController {


    @Autowired
    PersonService personService;

    @GetMapping("/test")
    public String test(){
        personService.test();
        return "";
    }
    @GetMapping("/save-person")
    public String save(){
        personService.savePerson();
//        personService.savePerson2();
        return "成功";
    }

    @GetMapping("/search")
    public List<Person> search(@Param("key")String key){
        return personService.search(key);
    }

    @GetMapping("/search2")
    public List<Person> findByDesc(@Param("key")String key){
        return personService.findByDesc(key);
    }

    @GetMapping("/page-search")
    public List<Person> pageSearch(@Param("key")String key,@Param("page")int page){
        return personService.pageSearch(key,page);
    }

}
