package com.example.demo.service.asset.impl;

import com.example.demo.dao.asset.AssetDetailDao;
import com.example.demo.dao.asset.AssetMainDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.asset.AssetDetail;
import com.example.demo.entity.asset.AssetMain;
import com.example.demo.service.asset.AssetDetailService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("AssetDetailService")
public class AssetDetailServiceImpl implements AssetDetailService {
    private final AssetDetailDao assetDetailDao;
    private final AssetMainDao assetMainDao;
    private final UserDao userDao;

    public AssetDetailServiceImpl(AssetDetailDao assetDetailDao, AssetMainDao assetMainDao, UserDao userDao) {
        this.assetDetailDao = assetDetailDao;
        this.assetMainDao = assetMainDao;
        this.userDao = userDao;
    }

    @Override
    public List<AssetDetail> save(LocalDate date, List<AssetDetail> accountingDetails) {
        AssetMain accounting = new AssetMain();
        accounting.setUserId(userDao.findByUsername(SecurityUtils.getSubject().getPrincipal().toString()).getId());
        accounting.setCreateDate(date);
        assetMainDao.save(accounting);
        for (AssetDetail accountingDetail : accountingDetails) {
            accountingDetail.setAssetMain(accounting);
        }
        return assetDetailDao.saveAll(accountingDetails);
    }

    @Override
    public void delAll(List<AssetDetail> assetDetails) {
        assetDetailDao.deleteAll(assetDetails);
    }

    @Override
    public List<AssetDetail> findAllByAssetMainOrderByTypeDesc(AssetMain assetMain) {
        return assetDetailDao.findAllByAssetMainOrderByTypeDesc(assetMain);
    }
}
