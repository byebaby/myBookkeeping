package com.example.demo.dao;

import com.example.demo.entity.AccountingView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountingViewDao extends JpaRepository<AccountingView, Integer> {
    List<AccountingView> findByusername(String username);
}
