package com.seata.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
@Configuration
public class SeataConfig {

    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("account-gts-seata-example", "my_test_tx_group");
    }
}
