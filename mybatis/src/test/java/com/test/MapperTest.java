package com.test;

import com.test.mybatis.UserMapper;
import com.test.mybatis.entity.User;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author guozhenhua
 * @date 2020/08/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationRun.class)
public class MapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){

        List<User> users = userMapper.selectUser();
        System.out.println(JSONArray.toJSONString(users));

    }
}
