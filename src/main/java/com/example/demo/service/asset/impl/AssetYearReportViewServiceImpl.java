package com.example.demo.service.asset.impl;

import com.example.demo.dao.asset.AssetYearReportViewDao;
import com.example.demo.entity.asset.AssetYearReportView;
import com.example.demo.service.asset.AssetYearReportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-06-27
 */
@Service("AssetReportViewService")
public class AssetYearReportViewServiceImpl implements AssetYearReportViewService {

    private final AssetYearReportViewDao assetYearReportViewDao;

    @Autowired
    public AssetYearReportViewServiceImpl(AssetYearReportViewDao assetYearReportViewDao) {
        this.assetYearReportViewDao = assetYearReportViewDao;
    }

    @Override
    public List<AssetYearReportView> findAll() {
        return assetYearReportViewDao.findAll();
    }

    @Override
    public AssetYearReportView findByMonthsAndUsername(String months, String username) {
        return assetYearReportViewDao.findByMonthsAndUsername(months,username);
    }

    @Override
    public List<AssetYearReportView> findByYearAndUsername(String year, String username) {
        return assetYearReportViewDao.findAllByMonthsLikeAndUsername(year,username);
    }
}

