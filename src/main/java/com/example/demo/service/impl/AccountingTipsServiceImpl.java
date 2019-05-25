package com.example.demo.service.impl;

import com.example.demo.dao.AccountingTipsDao;
import com.example.demo.entity.AccountingTips;
import com.example.demo.service.AccountingTipsService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountingTipsService")
public class AccountingTipsServiceImpl implements AccountingTipsService {
    private final AccountingTipsDao accountingTipsDao;

    public AccountingTipsServiceImpl(AccountingTipsDao accountingTipsDao) {
        this.accountingTipsDao = accountingTipsDao;
    }


    @Override
    public List<AccountingTips> findByUsername(String username) {
        return accountingTipsDao.findByUserName(username);
    }

    @Override
    public List<AccountingTips> save(List<AccountingTips> tips) {
        for (AccountingTips accountingTips : tips) {
            accountingTips.setUserName(SecurityUtils.getSubject().getPrincipal().toString());
        }
        return accountingTipsDao.saveAll(tips);
    }

    @Override
    public void del(List<AccountingTips> tips) {
        tips.removeIf(x -> x.getId() == null);
        accountingTipsDao.deleteAll(tips);
    }
}
