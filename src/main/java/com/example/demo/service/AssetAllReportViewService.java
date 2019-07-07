package com.example.demo.service;

import com.example.demo.entity.AssetAllReportView;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-07-06
 */
public interface AssetAllReportViewService {
    List<AssetAllReportView> findAllByUsername(String username);

}
