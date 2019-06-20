package com.example.demo.dao;

import com.example.demo.entity.AssetView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetViewDao extends JpaRepository<AssetView, Integer> {
    List<AssetView> findByusername(String username);
}
