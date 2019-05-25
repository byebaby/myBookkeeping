package com.example.demo;

import com.example.demo.mapper.AccountingTipsMapper;
import com.example.demo.service.AccountingTipsService;
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
    private AccountingTipsMapper accountingTipsMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountingTipsService accountingTipsService;

    @Test
    public void contextLoads() {
        accountingTipsMapper.toDTO(accountingTipsService.findByUsername("admin"));
        System.out.println("test");
    }
}

