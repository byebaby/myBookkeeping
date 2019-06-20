package com.example.demo.service;

import com.example.demo.entity.AssetDetail;

import java.time.LocalDate;
import java.util.List;

public interface AssetDetailService {
    List<AssetDetail> save(LocalDate date, List<AssetDetail> accountingDetails);
}
