package com.example.demo.dao;

import com.example.demo.entity.AccountingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingDetailDao extends JpaRepository<AccountingDetail, Integer> {
}
