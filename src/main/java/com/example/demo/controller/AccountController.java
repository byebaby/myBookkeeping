package com.example.demo.controller;

import com.example.demo.entity.AccountingView;
import com.example.demo.entity.MenuPath;
import com.example.demo.service.AssetsDebtService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {
    private final AssetsDebtService assetsDebtService;

    @Autowired
    public AccountController(AssetsDebtService assetsDebtService) {
        this.assetsDebtService = assetsDebtService;
    }

    @RequiresAuthentication
    @GetMapping("/account/assetsDebt")
    public String getDebt() {
        return "/account/assetsDebt";
    }

    @GetMapping("/account/accountingViewData")
    @ResponseBody
    public List<AccountingView> getAccountingViewData() {
        return assetsDebtService.findViewData(19);
    }
}
