package com.example.demo.service.impl;

import com.example.demo.dao.AccountingDao;
import com.example.demo.entity.Accounting;
import com.example.demo.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author cyb
 * @desc Generate-服务实现
 * @date 2019-05-23
 */
@Service("AccountingService")
public class AccountingServiceImpl implements AccountingService {

    private final AccountingDao accountingDao;

    @Autowired
    public AccountingServiceImpl(AccountingDao accountingDao) {
        this.accountingDao = accountingDao;
    }

    @Override
    public Accounting findById(Long id) {
        return accountingDao.findById(id);
    }
}

