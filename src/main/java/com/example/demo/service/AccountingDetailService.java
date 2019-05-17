package com.example.demo.service;

import com.example.demo.entity.AccountingDetail;

import java.time.LocalDate;
import java.util.List;

public interface AccountingDetailService {
    List<AccountingDetail> save(LocalDate date, List<AccountingDetail> accountingDetails);
}
