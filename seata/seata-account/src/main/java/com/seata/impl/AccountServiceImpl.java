package com.seata.impl;

import com.seata.dao.AccountMapper;
import com.test.entity.Account;
import com.test.service.AccountService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auth guozhenhua
 * @date 2019/08/29
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    @Override
    public int decreaseAccount(Account account) {
        System.out.println("全局事务accounts-----id ：" + RootContext.getXID());

        return accountMapper.decreaseAccount(account.getUser_id(), account.getAmount());
    }

}
