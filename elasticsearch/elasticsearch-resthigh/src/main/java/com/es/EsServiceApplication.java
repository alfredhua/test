package com.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

/**
 * @author hua
 */

public class EsServiceApplication {

    private static Logger logger = LoggerFactory.getLogger(EsServiceApplication.class);


    public static void main(String[] args){

        SpringApplication.run(Core.class,args);

    }


}
