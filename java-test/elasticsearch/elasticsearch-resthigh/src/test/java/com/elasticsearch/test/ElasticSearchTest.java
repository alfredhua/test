package com.elasticsearch.test;

import com.es.Core;
import com.es.config.RestHighClient;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

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
    public void createIndex() throws IOException {
        System.out.println(restHighClient.createIndex("user"));;
    }

    @Test
    public void getIndex() throws IOException {
        GetIndexResponse indexResponse = restHighClient.getIndex("user");
        System.out.println(indexResponse.getAliases());
        System.out.println(indexResponse.getMappings());
        System.out.println(indexResponse.getSettings());
    }

    @Test
    public void deleteIndex() throws IOException {
        System.out.println(restHighClient.deleteIndex("user"));
    }


    @Test
    public void index() throws IOException {
        User user=new User();
        user.setAge(18);
        user.setName("zhangsan");
        user.setSex((short) 1);
        restHighClient.index(user,"1","user");
    }


    @Test
    public void update() throws IOException {
        restHighClient.update("1","user");
    }

    @Test
    public void get() throws IOException {
        System.out.println(restHighClient.get("1","user"));
    }

    @Test
    public void delete() throws IOException {
        System.out.println(restHighClient.delete("1","user"));
    }


    @Test
    public void batchIndex() throws IOException {
        restHighClient.batchIndex();
    }

    @Test
    public void batchDelete() throws IOException {
        restHighClient.batchDelete();
    }

//    @Test
//    public void getIndex() throws Exception {
//        restHighClient.getIndex("movies","x3SBUAaGQ6e_rMy2DdkilA");
//    }

}
