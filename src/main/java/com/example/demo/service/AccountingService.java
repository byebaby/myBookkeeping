package com.example.demo.service;

import com.example.demo.entity.Accounting;

import java.util.Optional;

/**
 * @author cyb
 * @desc Generate-服务接口
 * @date 2019-05-23
 */
public interface AccountingService {
    Accounting findById(Long id);

}
