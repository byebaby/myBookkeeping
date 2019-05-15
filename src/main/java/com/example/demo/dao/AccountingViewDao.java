package com.example.demo.dao;

import com.example.demo.entity.AccountingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountingViewDao extends JpaRepository<AccountingView, Integer> {
    @Query(value = "select * from accounting_view where username=?1", nativeQuery = true)
    List<AccountingView> findViewDataByUserName(String username);
}
