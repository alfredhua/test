package com.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guozhenhua
 * @date 2020/04/16
 */

@RestController
@SpringBootApplication
@NacosPropertySource(dataId = "auth", autoRefreshed = true)
public class NacosConfigServerApplication {

    @NacosValue(value = "${a}", autoRefreshed = true)
    private String test;

    @GetMapping("/test")
    public String test(){
        return test;
    }



    public static void main(String[] args){

        SpringApplication.run(NacosConfigServerApplication.class,args);

//        logger.info("nacos config server  start......");

    }
}
