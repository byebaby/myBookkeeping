package com.example.demo.service.impl;

import com.example.demo.dao.AssetsDebtDao;
import com.example.demo.entity.AccountingView;
import com.example.demo.service.AssetsDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssetsDebtService")
public class AssetsDebtServiceImpl implements AssetsDebtService {
    private final AssetsDebtDao assetsDebtDao;

    @Autowired
    public AssetsDebtServiceImpl(AssetsDebtDao assetsDebtDao) {
        this.assetsDebtDao = assetsDebtDao;
    }

    @Override
    public List<AccountingView> findViewData(int id) {
        return assetsDebtDao.findViewData(id);
    }
}
