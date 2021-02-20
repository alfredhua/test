package com.elasticsearch.test;

import com.es.Core;
import com.es.config.RestHighClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guozhenhua
 * @date 2020/08/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Core.class)
public class ElasticSearchTest {

    @Autowired
    RestHighClient restHighClient;

    @Test
    public void getIndex() throws Exception {
        restHighClient.getIndex("movies","x3SBUAaGQ6e_rMy2DdkilA");
    }
}
