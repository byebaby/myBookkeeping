package com.example.demo.service.impl;

import com.example.demo.dao.AccountingTipsDao;
import com.example.demo.entity.AccountingTips;
import com.example.demo.service.AccountingTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountingTipsService")
public class AccountingTipsServiceImpl implements AccountingTipsService {
    private final AccountingTipsDao accountingTipsDao;

    @Autowired
    public AccountingTipsServiceImpl(AccountingTipsDao accountingTipsDao) {
        this.accountingTipsDao = accountingTipsDao;
    }


    @Override
    public List<AccountingTips> findByUsername(String username) {
        return accountingTipsDao.findByuserName(username);
    }
}
