package com.example.demo;

import com.example.demo.dao.AccountingDao;
import com.example.demo.dao.AccountingDetailDao;
import com.example.demo.entity.Accounting;
import com.example.demo.entity.AccountingDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private AccountingDetailDao accountingDetailDao;
    @Autowired
    private AccountingDao accountingDao;

    @Test
    public void contextLoads() {
        AccountingDetail accountingDetail = new AccountingDetail();
        Accounting accounting = new Accounting();
        accounting.setId(10);
//        accountingDao.save(accounting);
        accountingDetail.setAmount(111);
        accountingDetail.setAccounting(accounting);
        accountingDetailDao.save(accountingDetail);

    }
}

