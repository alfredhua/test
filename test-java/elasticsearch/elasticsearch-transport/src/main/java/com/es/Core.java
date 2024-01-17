package com.es;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author guozhenhua
 * @date 2021/02/19
 */
@SpringBootApplication
@EnableElasticsearchRepositories(
        basePackages = "com.es.resp"
)
public class Core {
}
