package com.consume.controller;

import com.consume.config.UrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guozhenhua
 * @date 2020/06/21
 */
@RestController
public class TestController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UrlConfig urlConfig;

    @Autowired
    FeignClientTest feignClient;

    @GetMapping("/consumer")
    public String consumer() {
        return feignClient.consumer();
    }



//
//    @GetMapping("/getByUsername")
//    public String getByUsername() {
//        return restTemplate.getForObject(urlConfig.getServerUrl() + "/{1}",String.class,"张三");
//    }

}
