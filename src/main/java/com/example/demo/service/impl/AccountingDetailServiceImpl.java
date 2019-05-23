package com.example.demo.service.impl;

import com.example.demo.dao.AccountingDao;
import com.example.demo.dao.AccountingDetailDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Accounting;
import com.example.demo.entity.AccountingDetail;
import com.example.demo.service.AccountingDetailService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("AccountingDetailService")
public class AccountingDetailServiceImpl implements AccountingDetailService {
    private final AccountingDetailDao accountingDetailDao;
    private final AccountingDao accountingDao;
    private final UserDao userDao;

    public AccountingDetailServiceImpl(AccountingDetailDao accountingDetailDao, AccountingDao accountingDao, UserDao userDao) {
        this.accountingDetailDao = accountingDetailDao;
        this.accountingDao = accountingDao;
        this.userDao = userDao;
    }

    @Override
    public List<AccountingDetail> save(LocalDate date, List<AccountingDetail> accountingDetails) {
        Accounting accounting = new Accounting();
        accounting.setUserId(userDao.findByUsername(SecurityUtils.getSubject().getPrincipal().toString()).getId());
        accounting.setCreateDate(date);
        accountingDao.save(accounting);
        for (AccountingDetail accountingDetail : accountingDetails) {
            accountingDetail.setPid(accounting.getId());
        }
        return accountingDetailDao.saveAll(accountingDetails);
    }
}
