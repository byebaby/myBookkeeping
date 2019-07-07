package com.example.demo.service;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;

import java.time.LocalDate;
import java.util.List;

public interface AssetDetailService {
    List<AssetDetail> save(LocalDate date, List<AssetDetail> accountingDetails);

    void delAll(List<AssetDetail> assetDetails);

    List<AssetDetail> findAllByAssetMainOrderByTypeDesc(AssetMain assetMain);
}
