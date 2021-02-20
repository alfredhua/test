package com.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auth guozhenhua
 * @date 2018/11/22
 */
@SpringBootApplication
@EnableEurekaClient
public class DictionaryServerApplication {

    public static void main(String[] args){
        SpringApplication.run(Core.class, args);
    }
}
