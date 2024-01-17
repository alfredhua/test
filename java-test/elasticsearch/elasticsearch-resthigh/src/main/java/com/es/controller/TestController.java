package com.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guozhenhua
 * @date 2021/02/19
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "";
    }
}
