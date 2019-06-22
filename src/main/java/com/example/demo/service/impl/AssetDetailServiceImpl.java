package com.example.demo.service.impl;

import com.example.demo.dao.AssetDetailDao;
import com.example.demo.dao.AssetMainDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;
import com.example.demo.service.AssetDetailService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("AccountingDetailService")
public class AssetDetailServiceImpl implements AssetDetailService {
    private final AssetDetailDao accountingDetailDao;
    private final AssetMainDao accountingDao;
    private final UserDao userDao;

    public AssetDetailServiceImpl(AssetDetailDao accountingDetailDao, AssetMainDao accountingDao, UserDao userDao) {
        this.accountingDetailDao = accountingDetailDao;
        this.accountingDao = accountingDao;
        this.userDao = userDao;
    }

    @Override
    public List<AssetDetail> save(LocalDate date, List<AssetDetail> accountingDetails) {
        AssetMain accounting = new AssetMain();
        accounting.setUserId(userDao.findByUsername(SecurityUtils.getSubject().getPrincipal().toString()).getId());
        accounting.setCreateDate(date);
        accountingDao.save(accounting);
        for (AssetDetail accountingDetail : accountingDetails) {
            accountingDetail.setAssetMain(accounting);
        }
        return accountingDetailDao.saveAll(accountingDetails);
    }
}
