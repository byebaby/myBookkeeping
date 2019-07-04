package com.example.demo.dao;

import com.example.demo.entity.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetMainDao extends JpaRepository<AssetMain, Long> {
    Optional<AssetMain> findById(Long id);

    void deleteById(Long id);
}
