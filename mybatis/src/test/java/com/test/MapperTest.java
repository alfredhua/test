package com.test;

import com.test.mybatis.UserMapper;
import com.test.mybatis.entity.User;
import net.minidev.json.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

    @Autowired
    SqlSession sqlSession;

    //走Mybatis-Spring 中的SqlSessionTemplate 会反射Mybatis的SqlSession然后调用SelectList方法
    @Test
    public void test2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
    }


    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
    }
}
