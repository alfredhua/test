package com.test;

import com.test.entity.Order;
import com.test.impl.GlobalTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SeataTestApplication.class)
public class SeataTest {


    @Autowired
    GlobalTestService globalTestService;

    @Test
    public void testGlobalTransactional(){
        Order order=new Order();
        order.setUser_id("1");
        order.setOrder_amount(50.00);
        globalTestService.testGlobalTransactional(order);
    }
}
