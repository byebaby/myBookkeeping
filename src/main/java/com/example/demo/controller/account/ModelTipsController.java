package com.example.demo.controller.account;

import com.example.demo.entity.AccountingDetail;
import com.example.demo.entity.AccountingTips;
import com.example.demo.mapper.AccountingTipsMapper;
import com.example.demo.mapper.dto.AccountingTipsDto;
import com.example.demo.service.AccountingService;
import com.example.demo.service.AccountingTipsService;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ModelTipsController {
    private final AccountingTipsMapper accountingTipsMapper;
    private final AccountingTipsService accountingTipsService;
    private final AccountingService accountingService;

    public ModelTipsController(AccountingTipsMapper accountingTipsMapper, AccountingTipsService accountingTipsService, AccountingService accountingService) {
        this.accountingTipsMapper = accountingTipsMapper;
        this.accountingTipsService = accountingTipsService;
        this.accountingService = accountingService;
    }

    @GetMapping("/account/accountingTipsForm")
    public String getAccountingTipsForm() {
        return "/account/accountingTipsForm";
    }

    @GetMapping("/account/ModelTipsData")
    @ResponseBody
    public Json getModelTipsData() {
        List<AccountingTips> tipsList = accountingTipsService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        List<AccountingTipsDto> dtos = accountingTipsMapper.toDTO(tipsList);
        return Json.succ("viewData", dtos).data("count", dtos.size());

    }

    @GetMapping("/account/ModelTipsDataIgnore")
    @ResponseBody
    public Json getModelTipsDataIgnore(Long id) {
        List<AccountingTips> tipsList = accountingTipsService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        if (id == null) {
            List<AccountingTipsDto> dtos = accountingTipsMapper.toDTOIgnoreId(tipsList);
            return Json.succ("viewData", dtos).data("count", dtos.size());
        } else {
            List<AccountingDetail> details = accountingService.findById(id).getAccountingDetail();
            return Json.succ("viewData", details).data("count", details.size());
        }


    }

    @PostMapping("/account/ModelTipsData")
    @ResponseBody
    public Json postModelTipsData(@RequestBody List<AccountingTips> tips) {
        List<AccountingTips> tipsList = accountingTipsService.save(tips);
        return Json.succ("viewData", accountingTipsMapper.toDTOIgnoreId(tipsList)).data("count", tipsList.size());
    }


    @PostMapping("/account/ModelTipsDataDelete")
    @ResponseBody
    public Json deleteModelTipsData(@RequestBody List<AccountingTips> tips) {

        accountingTipsService.del(tips);
        return Json.succ("deleteData");
    }
}
