package com.example.demo;

import com.example.demo.dao.AccountingDao;
import com.example.demo.dao.AccountingDetailDao;
import com.example.demo.entity.Accounting;
import com.example.demo.entity.AccountingDetail;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountingDao accountingDao;

    @Test
    public void contextLoads() {
        userService.findUserByName("qqqqqq");

    }
}

