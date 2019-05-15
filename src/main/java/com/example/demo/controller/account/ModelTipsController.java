package com.example.demo.controller.account;

import com.example.demo.entity.AccountingTips;
import com.example.demo.service.AccountingTipsService;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ModelTipsController {

    private final AccountingTipsService accountingTipsService;

    @Autowired
    public ModelTipsController(AccountingTipsService accountingTipsService) {
        this.accountingTipsService = accountingTipsService;
    }

    @GetMapping("/account/accountingTipsForm")
    public String getAccountingTipsForm() {
        return "/account/accountingTipsForm";
    }

    @GetMapping("/account/ModelTipsData")
    @ResponseBody
    public Json getModelTipsData() {
        List<AccountingTips> tipsList = accountingTipsService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        return Json.succ("viewData", tipsList).data("count", tipsList.size());
    }

}
