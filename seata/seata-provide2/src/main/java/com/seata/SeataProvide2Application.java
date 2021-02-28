package com.seata;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.seata.dao"})
@EnableDubbo(scanBasePackages = "com.seata.impl")
public class SeataProvide2Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataProvide2Application.class,args);
    }
}
