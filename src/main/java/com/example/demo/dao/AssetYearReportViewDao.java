package com.example.demo.dao;

import com.example.demo.entity.AssetYearReportView;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author cyb
 * @desc Generate-Dao
 * @date 2019-06-27
 */
public interface AssetYearReportViewDao extends JpaRepository<AssetYearReportView, String> {
    AssetYearReportView findByMonthsAndUsername(String months, String username);
}