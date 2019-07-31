package com.example.demo.dao;

import com.example.demo.entity.AssetMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AssetMainDao extends JpaRepository<AssetMain, Long> {
    Optional<AssetMain> findById(Long id);

    @Query(value = "select * FROM asset_main WHERE user_id=:userId AND create_date LIKE :date", nativeQuery = true)
    List<AssetMain> findAllByUserIdAndCreateDateLike(@Param("userId") Long userId, @Param("date") String date);

    void deleteById(Long id);
}
