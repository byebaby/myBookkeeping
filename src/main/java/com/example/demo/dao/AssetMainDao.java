package com.example.demo.dao;

import com.example.demo.entity.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetMainDao extends JpaRepository<AssetMain, Integer> {
    AssetMain findById(Long id);

    void deleteById(Long id);
}
