package com.example.demo.dao;

import com.example.demo.entity.AssetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetModelDao extends JpaRepository<AssetModel, Long> {
    List<AssetModel> findByUserName(String username);
}

