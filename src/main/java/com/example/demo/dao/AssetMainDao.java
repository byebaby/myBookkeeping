package com.example.demo.dao;

import com.example.demo.entity.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssetMainDao extends JpaRepository<AssetMain, Long> {
    Optional<AssetMain> findById(Long id);

    @Query(value = "select * from asset_main where  create_date like :date", nativeQuery = true)
    List<AssetMain> findAllByCreateDateLikeMonths(String date);

    void deleteById(Long id);
}
