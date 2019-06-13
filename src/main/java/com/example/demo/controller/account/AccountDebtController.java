package com.example.demo.controller.account;

import com.example.demo.entity.AccountingDetail;
import com.example.demo.entity.AccountingView;
import com.example.demo.service.AccountingDetailService;
import com.example.demo.service.AccountingViewService;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AccountDebtController {
    private final AccountingViewService accountingViewService;
    private final AccountingDetailService accountingDetailService;

    @Autowired
    public AccountDebtController(AccountingViewService accountingViewService, AccountingDetailService accountingDetailService) {
        this.accountingViewService = accountingViewService;
        this.accountingDetailService = accountingDetailService;
    }

    @GetMapping("/account/assetsDebt")
    public String getDebt() {
        return "/account/assetsDebt";
    }

    @GetMapping("/account/assetsDebtForm")
    public String getAddForm(Long id, ModelMap modelMap) {
        if (id != null) {
            modelMap.addAttribute("id", id);
        }
        return "/account/assetsDebtForm";
    }

    @PostMapping("/account/assetsDebtForm")
    @ResponseBody
    public Json saveAddForm(String date, @RequestBody List<AccountingDetail> data) {
        accountingDetailService.save(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), data);
        return Json.succ("saveDetail");
    }


    @GetMapping("/account/accountingViewData")
    @ResponseBody
    public Json getAccountingViewData() {
        List<AccountingView> accountingViews = accountingViewService.findViewDataByUserName(SecurityUtils.getSubject().getPrincipal().toString());
        return Json.succ("viewData", accountingViews).data("count", accountingViews.size());
    }
}
