package com.seata.impl;

import com.seata.dao.AccountMapper;
import com.test.entity.Account;
import com.test.service.AccountService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @auth guozhenhua
 * @date 2019/08/29
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    public void updateAccount(Account account) {
        account.setId(1L);
        account.setMoney(BigDecimal.valueOf(100L));
        accountMapper.updateAccount(account);
    }

}
