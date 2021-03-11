package com.test.impl;


import com.test.entity.Account;
import com.test.entity.Order;
import com.test.entity.Storage;
import com.test.service.AccountService;
import com.test.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class GlobalTestService {


    @Reference
    AccountService accountService;


    @Reference
    StorageService storageService;



    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public void testGlobalTransactional(Order order) {
        //扣减用户账户
        System.out.println("全局事务test-----id ：" + RootContext.getXID());

        Account accountDTO = new Account();
        accountDTO.setUser_id(order.getUser_id());
        accountDTO.setAmount(order.getOrder_amount());
        accountService.decreaseAccount(accountDTO);  //扣减账户

        Storage storage = new Storage();
        storage.setCommodityCode("C201901140001");
        storage.setCount(1);
        storageService.decreaseStorage(storage);

        throw new RuntimeException("测试抛异常后，分布式事务回滚！");
    }

}
