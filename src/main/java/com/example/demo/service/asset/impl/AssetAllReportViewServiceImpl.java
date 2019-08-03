package com.example.demo.service.asset.impl;

import com.example.demo.dao.asset.AssetAllReportViewDao;
import com.example.demo.entity.asset.AssetAllReportView;
import com.example.demo.service.asset.AssetAllReportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-07-06
 */
@Service("AssetAllReportViewService")
public class AssetAllReportViewServiceImpl implements AssetAllReportViewService {

    private final AssetAllReportViewDao assetallreportviewDao;

    @Autowired
    public AssetAllReportViewServiceImpl(AssetAllReportViewDao assetallreportviewDao) {
        this.assetallreportviewDao = assetallreportviewDao;
    }

    @Override
    public List<AssetAllReportView> findAllByUsername(String username) {
        return assetallreportviewDao.findAllByUsername(username);
    }
}
