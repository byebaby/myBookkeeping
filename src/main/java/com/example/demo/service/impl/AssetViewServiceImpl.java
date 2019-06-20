package com.example.demo.service.impl;

import com.example.demo.dao.AssetViewDao;
import com.example.demo.entity.AssetView;
import com.example.demo.service.AssetViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountingViewService")
public class AssetViewServiceImpl implements AssetViewService {
    private final AssetViewDao accountingViewDao;

    public AssetViewServiceImpl(AssetViewDao accountingViewDao) {
        this.accountingViewDao = accountingViewDao;
    }

    @Override
    public List<AssetView> findViewDataByUserName(String userName) {
        return accountingViewDao.findByusername(userName);
    }
}
