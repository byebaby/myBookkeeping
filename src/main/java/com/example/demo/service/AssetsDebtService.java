package com.example.demo.service;

import com.example.demo.entity.AccountingView;

import java.util.List;

public interface AssetsDebtService {
    List<AccountingView> findViewData(int id);
}
