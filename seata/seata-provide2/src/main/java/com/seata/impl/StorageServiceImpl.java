package com.seata.impl;

import com.seata.dao.StorageMapper;
import com.test.entity.Storage;
import com.test.service.StorageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */
@Service
public class StorageServiceImpl implements StorageService {


    @Autowired
    StorageMapper storageMapper;

    @Override
    public int decreaseStorage(Storage storage) {
        storage.setId(1);
        storage.setCount(10);
        storageMapper.updateStorage(storage);
        return 0;
    }


}
