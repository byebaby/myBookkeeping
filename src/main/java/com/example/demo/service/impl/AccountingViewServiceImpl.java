package com.example.demo.service.impl;

import com.example.demo.dao.AccountingViewDao;
import com.example.demo.entity.AccountingView;
import com.example.demo.service.AccountingViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountingViewService")
public class AccountingViewServiceImpl implements AccountingViewService {
    private final AccountingViewDao accountingViewDao;

    public AccountingViewServiceImpl(AccountingViewDao accountingViewDao) {
        this.accountingViewDao = accountingViewDao;
    }

    @Override
    public List<AccountingView> findViewDataByUserName(String userName) {
        return accountingViewDao.findByusername(userName);
    }
}
