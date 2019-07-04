package com.example.demo.service;

import com.example.demo.entity.AssetReportView;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-06-27
 */
public interface AssetReportViewService {
    List<AssetReportView> findAll();

    AssetReportView findByMonthsAndUsername(String months,String username);
}
