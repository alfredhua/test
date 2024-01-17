package com.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guozhenhua
 * @date 2020/06/21
 */
@RestController
public class TestController {

    @RequestMapping("/{name}")
    public String home(@PathVariable("name") String name) {
        return "Hello "+name;
    }
}
