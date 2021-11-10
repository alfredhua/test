package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication
@MapperScan(basePackages = "com.test.mybatis")
@ImportResource(locations = "classpath:config.xml")
@EnableAutoConfiguration
public class ApplicationRun {

}
