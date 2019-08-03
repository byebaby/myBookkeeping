package com.example.demo.service.asset;

import com.example.demo.entity.asset.AssetView;

import java.util.List;

public interface AssetViewService {
    List<AssetView> findViewDataByUserName(String userName);

}
