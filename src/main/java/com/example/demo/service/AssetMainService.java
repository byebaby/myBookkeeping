package com.example.demo.service;

import com.example.demo.entity.AssetMain;

import java.util.List;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-05-23
 */
public interface AssetMainService {
    AssetMain findById(Long id);
    List<AssetMain> findAllByUserIdAndCreateDateLike(Long id,String date);
    void save(AssetMain assetMain);

    void deleteById(Long id);
}
