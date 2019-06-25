package com.example.demo.service;

import com.example.demo.entity.AssetMain;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-05-23
 */
public interface AssetMainService {
    AssetMain findById(Long id);

    void save(AssetMain assetMain);

    void deleteById(Long id);
}
