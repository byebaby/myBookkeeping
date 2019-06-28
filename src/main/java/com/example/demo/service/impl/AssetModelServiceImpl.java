package com.example.demo.service.impl;

import com.example.demo.dao.AssetModelDao;
import com.example.demo.entity.AssetModel;
import com.example.demo.service.AssetModelService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssetModelService")
public class AssetModelServiceImpl implements AssetModelService {
    private final AssetModelDao accountingTipsDao;

    public AssetModelServiceImpl(AssetModelDao accountingTipsDao) {
        this.accountingTipsDao = accountingTipsDao;
    }


    @Override
    public List<AssetModel> findByUsername(String username) {
        return accountingTipsDao.findByUserName(username);
    }

    @Override
    public List<AssetModel> save(List<AssetModel> tips) {
        for (AssetModel accountingTips : tips) {
            accountingTips.setUserName(SecurityUtils.getSubject().getPrincipal().toString());
        }
        return accountingTipsDao.saveAll(tips);
    }

    @Override
    public void del(List<AssetModel> tips) {
        tips.removeIf(x -> x.getId() == null);
        accountingTipsDao.deleteAll(tips);
    }
}
