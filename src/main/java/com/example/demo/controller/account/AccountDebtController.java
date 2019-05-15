package com.example.demo.controller.account;

import com.example.demo.entity.AccountingView;
import com.example.demo.service.AccountingViewService;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountDebtController {
    private final AccountingViewService accountingViewService;

    @Autowired
    public AccountDebtController(AccountingViewService accountingViewService) {
        this.accountingViewService = accountingViewService;
    }

    @GetMapping("/account/assetsDebt")
    public String getDebt() {
        return "/account/assetsDebt";
    }

    @GetMapping("/account/assetsDebtForm")
    public String getAddForm() {
        return "/account/assetsDebtForm";
    }


    @GetMapping("/account/accountingViewData")
    @ResponseBody
    public Json getAccountingViewData() {
        List<AccountingView> accountingViews = accountingViewService.findViewDataByUserName(SecurityUtils.getSubject().getPrincipal().toString());
        return Json.succ("viewData", accountingViews).data("count", accountingViews.size());
    }
}
