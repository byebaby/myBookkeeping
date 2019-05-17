package com.example.demo.dao;

import com.example.demo.entity.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingDao extends JpaRepository<Accounting, Integer> {
}
