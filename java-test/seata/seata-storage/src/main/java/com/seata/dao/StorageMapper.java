package com.seata.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
public interface StorageMapper {

    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);

}
