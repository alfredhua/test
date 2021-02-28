package com.seata.dao;

import com.test.entity.Account;
import org.apache.ibatis.annotations.Update;

/**
 * @auth guozhenhua
 * @date 2019/08/29
 */
public interface AccountMapper {



    @Update("update account set money=#{money} where id=#{id}")
    void updateAccount(Account account);
}
