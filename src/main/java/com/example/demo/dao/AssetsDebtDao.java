package com.example.demo.dao;

import com.example.demo.entity.AccountingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetsDebtDao extends JpaRepository<AccountingView, Integer> {
    @Query(value = "select * from accounting_view where id=?1", nativeQuery = true)
    List<AccountingView> findViewData(int id);
}
