package com.example.demo.dao.asset;

import com.example.demo.entity.asset.AssetDetail;
import com.example.demo.entity.asset.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetDetailDao extends JpaRepository<AssetDetail, Long> {
    List<AssetDetail> findAllByAssetMainOrderByTypeDesc(AssetMain assetMain);
}