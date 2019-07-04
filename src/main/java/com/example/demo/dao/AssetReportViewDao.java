package com.example.demo.dao;

import com.example.demo.entity.AssetReportView;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author cyb
 * @desc Generate-Dao
 * @date 2019-06-27
 */
public interface AssetReportViewDao extends JpaRepository<AssetReportView, String> {
    AssetReportView findByMonthsAndUsername(String months,String username);
}