package com.example.demo.dao;

import com.example.demo.entity.AccountingTips;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountingTipsDao extends JpaRepository<AccountingTips, Integer> {
    List<AccountingTips> findByuserName(String username);
}

