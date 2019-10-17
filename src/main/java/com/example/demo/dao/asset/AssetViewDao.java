package com.example.demo.dao.asset;

import com.example.demo.entity.asset.AssetView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetViewDao extends JpaRepository<AssetView, Long> {
    List<AssetView> findByusernameOrderByCreateDate(String username);
}
