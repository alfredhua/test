package com.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guozhenhua
 * @date 2020/07/06
 */
@RestController
public class TestController {


    @Autowired
    UrlConfig urlConfig;

    @Autowired
    ConsumerService consumerService;


    @GetMapping("/getByUsername")
    public String getByUsername() {
        return consumerService.consumer();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Component
    class ConsumerService {


        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject(urlConfig.getServerUrl() + "/{1}",String.class,"张三");
        }

        public String fallback() {
            return "fallback";
        }

    }

}
