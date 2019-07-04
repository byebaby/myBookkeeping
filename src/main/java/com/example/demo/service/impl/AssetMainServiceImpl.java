package com.example.demo.service.impl;

import com.example.demo.dao.AssetMainDao;
import com.example.demo.entity.AssetMain;
import com.example.demo.service.AssetMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-05-23
 */
@Service("AssetMainService")
public class AssetMainServiceImpl implements AssetMainService {

    private final AssetMainDao assetMainDao;

    @Autowired
    public AssetMainServiceImpl(AssetMainDao assetMainDao) {
        this.assetMainDao = assetMainDao;
    }

    @Override
    public AssetMain findById(Long id) {
        return assetMainDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void save(AssetMain assetMain) {
        assetMainDao.save(assetMain);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        assetMainDao.deleteById(id);
    }
}

