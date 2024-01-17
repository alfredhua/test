package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @author guozhenhua
 * @date 2020/04/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Server2Application {

    public static void main(String[] args){

        SpringApplication.run(Server2Application.class);

    }
}
