package com.example.demo.service.asset;

import com.example.demo.entity.asset.AssetModel;

import java.util.List;

public interface AssetModelService {
    List<AssetModel> findByUserNameOrderByTypeDesc(String username);
    List<AssetModel> findByUsername(String username);
    List<AssetModel> save(List<AssetModel> tips);

    void del(List<AssetModel> tips);
}
