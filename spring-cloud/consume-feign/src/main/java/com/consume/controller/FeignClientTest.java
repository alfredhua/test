package com.consume.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("server")
public interface FeignClientTest {

    @GetMapping("/getByUsername")
    String consumer();


}