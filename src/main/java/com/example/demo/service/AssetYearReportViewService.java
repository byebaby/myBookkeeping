package com.example.demo.service;

import com.example.demo.entity.AssetYearReportView;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-06-27
 */
public interface AssetYearReportViewService {
    List<AssetYearReportView> findAll();

    AssetYearReportView findByMonthsAndUsername(String months, String username);
}
