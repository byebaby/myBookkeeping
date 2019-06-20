package com.example.demo.service;

import com.example.demo.entity.AssetView;

import java.util.List;

public interface AssetViewService {
    List<AssetView> findViewDataByUserName(String userName);
}
