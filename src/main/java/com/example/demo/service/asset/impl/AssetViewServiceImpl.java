package com.example.demo.service.asset.impl;

import com.example.demo.dao.asset.AssetViewDao;
import com.example.demo.entity.asset.AssetView;
import com.example.demo.service.asset.AssetViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssetViewService")
public class AssetViewServiceImpl implements AssetViewService {
    private final AssetViewDao accountingViewDao;

    public AssetViewServiceImpl(AssetViewDao accountingViewDao) {
        this.accountingViewDao = accountingViewDao;
    }

    @Override
    public List<AssetView> findViewDataByUserName(String userName) {
        return accountingViewDao.findByusernameOrderByCreateDate(userName);
    }


}
