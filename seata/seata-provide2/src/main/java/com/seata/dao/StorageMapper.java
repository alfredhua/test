package com.seata.dao;

import com.test.entity.Storage;
import org.apache.ibatis.annotations.Update;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
public interface StorageMapper {

    @Update("update storage set count=#{count} where id=#{id}")
    void updateStorage(Storage storage);

}
