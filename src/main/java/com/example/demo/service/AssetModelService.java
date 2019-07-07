package com.example.demo.service;

import com.example.demo.entity.AssetModel;

import java.util.List;

public interface AssetModelService {
    List<AssetModel> findByUserNameOrderByTypeDesc(String username);
    List<AssetModel> findByUsername(String username);
    List<AssetModel> save(List<AssetModel> tips);

    void del(List<AssetModel> tips);
}
