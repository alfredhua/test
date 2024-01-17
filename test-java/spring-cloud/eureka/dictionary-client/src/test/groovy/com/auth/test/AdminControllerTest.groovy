package com.auth.test

import com.auth.AuthServerApplication
import com.auth.service.dao.entity.Admin
import com.common.response.ResultResponse
import org.apache.commons.collections.map.MultiValueMap
import org.springframework.http.MediaType
import org.springframework.http.HttpHeaders
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.util.LinkedMultiValueMap

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
class AdminControllerTest{

    @Autowired
    private TestRestTemplate testRestTemplate

    @Test
     void saveAdmin() throws Exception {

        Admin admin=new Admin()
        admin.setPhone("18331385758")
        admin.setEmail("aaa@qq.com")
        admin.set_active(true)
        admin.setPassword("123")
        admin.setRole_list_json("11111")
        admin.setUser_name("user")
        def result = testRestTemplate.postForObject("/saveAdmin",admin,ResultResponse.class)
        print result

    }

    @Test
    void saveAdmin2() {
        MultiValueMap map = new LinkedMultiValueMap() as MultiValueMap
        map.put("id", "123333")
        ResponseEntity<String> entity = testRestTemplate.postForEntity("/saveAdmin", map, String.class)
        String body = entity.getBody()
        print body
    }

    @Test
    void get() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap() as MultiValueMap
        multiValueMap.put("id","1")
        def entity = testRestTemplate.getForEntity("/get", Admin.class)
        print entity
    }


}