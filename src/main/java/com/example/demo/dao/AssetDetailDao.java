package com.example.demo.dao;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetDetailDao extends JpaRepository<AssetDetail, Long> {
    List<AssetDetail> findAllByAssetMain(AssetMain assetMain);
}