package com.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guozhenhua
 * @date 2020/04/16
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumeFeignApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumeFeignApplication.class);

    }
}
