package com.example.demo.service.impl;

import com.example.demo.dao.AssetReportViewDao;
import com.example.demo.entity.AssetReportView;
import com.example.demo.service.AssetReportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-06-27
 */
@Service("AssetReportViewService")
public class AssetReportViewServiceImpl implements AssetReportViewService {

    private final AssetReportViewDao assetreportviewDao;

    @Autowired
    public AssetReportViewServiceImpl(AssetReportViewDao assetreportviewDao) {
        this.assetreportviewDao = assetreportviewDao;
    }

    @Override
    public List<AssetReportView> findAll() {
        return assetreportviewDao.findAll();
    }

    @Override
    public AssetReportView findByMonthsAndUsername(String months,String username) {
        return assetreportviewDao.findByMonthsAndUsername(months,username);
    }
}

