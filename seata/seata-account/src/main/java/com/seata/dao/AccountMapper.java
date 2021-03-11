package com.seata.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @auth guozhenhua
 * @date 2019/08/29
 */
public interface AccountMapper {



    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);

    int testGlobalLock(@Param("userId") String userId);


}
