package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guozhenhua
 * @date 2020/04/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {

    public static void main(String[] args){

        SpringApplication.run(ServerApplication.class);

    }
}
