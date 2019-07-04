package com.example.demo.controller.asset;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;
import com.example.demo.entity.AssetReportView;
import com.example.demo.mapper.dto.AssetReportViewDto;
import com.example.demo.service.AssetDetailService;
import com.example.demo.service.AssetReportViewService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final AssetReportViewService assetReportViewService;
    private final AssetDetailService assetDetailService;

    public ReportController(AssetReportViewService assetReportViewService, AssetDetailService assetDetailService) {
        this.assetReportViewService = assetReportViewService;
        this.assetDetailService = assetDetailService;
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
        for (int i = 1; i < 13; i++) {
            for (AssetReportView assetReportView : assetReportViews) {
                int months = Integer.parseInt(assetReportView.getMonths().substring(assetReportView.getMonths().lastIndexOf("-") + 1));
                if (i == months) {
                    netAssets.add(i + "月", assetReportView.getNetAssets(), true);
                    netIncome.add(i + "月", assetReportView.getNetIncome(), true);
                    income.add(i + "月", assetReportView.getIncome(), true);
                    expense.add(i + "月", assetReportView.getExpense(), true);
                    break;
                } else {
                    netAssets.add(i + "月", null, null);
                    netIncome.add(i + "月", null, null);
                    income.add(i + "月", null, null);
                    expense.add(i + "月", null, null);
                }
            }
        }
        assetReportViewDtos.add(netAssets);
        assetReportViewDtos.add(netIncome);
        assetReportViewDtos.add(income);
        assetReportViewDtos.add(expense);
        return assetReportViewDtos;
    }

    @GetMapping("/asset/getMonthsReportData")
    @ResponseBody
    public List<AssetReportViewDto> getMonthsReportData(String months) {
        AssetReportView assetReportView = assetReportViewService.findByMonthsAndUsername(months, SecurityUtils.getSubject().getPrincipal().toString());
        AssetMain assetMain = new AssetMain();
        assetMain.setId(assetReportView.getId());
        List<AssetDetail> assetDetails = assetDetailService.findAllByAssetMain(assetMain);
        System.out.println(assetReportView);
        return null;
    }


}
