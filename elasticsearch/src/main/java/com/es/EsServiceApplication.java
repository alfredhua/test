package com.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author hua
 */
@SpringBootApplication
@EnableElasticsearchRepositories(
        basePackages = "com.es.resp"
)
public class EsServiceApplication {

    private static Logger logger = LoggerFactory.getLogger(EsServiceApplication.class);


    public static void main(String[] args){

        SpringApplication.run(EsServiceApplication.class,args);

    }


}
