package com.example.demo.controller.asset;

import com.example.demo.entity.AssetReportView;
import com.example.demo.mapper.dto.AssetReportViewDto;
import com.example.demo.service.AssetReportViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final AssetReportViewService assetReportViewService;

    public ReportController(AssetReportViewService assetReportViewService) {
        this.assetReportViewService = assetReportViewService;
    }

    @GetMapping("/asset/report")
    public String report() {
        return "/asset/report";
    }

    @GetMapping("/asset/getReportData")
    @ResponseBody
    public List<AssetReportViewDto> getReportData() {
        List<AssetReportView> assetReportViews = assetReportViewService.findAll();
        List<AssetReportViewDto> assetReportViewDtos = new ArrayList<>();
        AssetReportViewDto netAssets = new AssetReportViewDto("净资产");
        AssetReportViewDto netIncome = new AssetReportViewDto("净收入");
        AssetReportViewDto income = new AssetReportViewDto("收入");
        AssetReportViewDto expense = new AssetReportViewDto("支出");
        for (AssetReportView assetReportView : assetReportViews) {
            int months = Integer.parseInt(assetReportView.getMonths().substring(assetReportView.getMonths().lastIndexOf("-") + 1));
            netAssets.getData()[months - 1] = assetReportView.getNetAssets();
            netIncome.getData()[months - 1] = assetReportView.getIncome();
            income.getData()[months - 1] = assetReportView.getIncome();
            expense.getData()[months - 1] = assetReportView.getExpense();
        }
        assetReportViewDtos.add(netAssets);
        assetReportViewDtos.add(netIncome);
        assetReportViewDtos.add(income);
        assetReportViewDtos.add(expense);
        return assetReportViewDtos;
    }
}
