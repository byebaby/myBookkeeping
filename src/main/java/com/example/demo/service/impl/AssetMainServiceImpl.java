package com.example.demo.service.impl;

import com.example.demo.dao.AssetMainDao;
import com.example.demo.entity.AssetMain;
import com.example.demo.service.AssetMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-05-23
 */
@Service("AccountingService")
public class AssetMainServiceImpl implements AssetMainService {

    private final AssetMainDao accountingDao;

    @Autowired
    public AssetMainServiceImpl(AssetMainDao accountingDao) {
        this.accountingDao = accountingDao;
    }

    @Override
    public AssetMain findById(Long id) {
        return accountingDao.findById(id);
    }

    @Override
    public void save(AssetMain assetMain) {
        accountingDao.save(assetMain);
    }
}

