package com.seata;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.seata.dao"})
@EnableDubbo(scanBasePackages = "com.seata.impl")
@EnableTransactionManagement
public class SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication.class,args);
    }
}
