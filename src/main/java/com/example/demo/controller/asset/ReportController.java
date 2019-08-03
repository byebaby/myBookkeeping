package com.example.demo.controller.asset;

import com.example.demo.entity.asset.AssetAllReportView;
import com.example.demo.entity.asset.AssetDetail;
import com.example.demo.entity.asset.AssetMain;
import com.example.demo.entity.asset.AssetYearReportView;
import com.example.demo.mapper.dto.AssetReportViewDto;
import com.example.demo.service.asset.AssetAllReportViewService;
import com.example.demo.service.asset.AssetDetailService;
import com.example.demo.service.asset.AssetYearReportViewService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final AssetYearReportViewService assetYearReportViewService;
    private final AssetDetailService assetDetailService;
    private final AssetAllReportViewService assetAllReportViewService;

    public ReportController(AssetYearReportViewService assetYearReportViewService, AssetDetailService assetDetailService, AssetAllReportViewService assetAllReportViewService) {
        this.assetYearReportViewService = assetYearReportViewService;
        this.assetDetailService = assetDetailService;
        this.assetAllReportViewService = assetAllReportViewService;
    }

    @GetMapping("/asset/report")
    public String report() {
        return "asset/report";
    }

    @GetMapping("/asset/getAllReportData")
    @ResponseBody
    public List<AssetReportViewDto> getAllReportData() {
        List<AssetAllReportView> assetAllReportViews = assetAllReportViewService.findAllByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        List<AssetReportViewDto> assetReportViewDtos = new ArrayList<>();
        AssetReportViewDto netAssets = new AssetReportViewDto("净资产");
        AssetReportViewDto netIncome = new AssetReportViewDto("净收入");
        AssetReportViewDto income = new AssetReportViewDto("收入");
        AssetReportViewDto expense = new AssetReportViewDto("支出");
        for (AssetAllReportView assetAllReportView : assetAllReportViews) {
            netAssets.add(assetAllReportView.getYear() + "年", assetAllReportView.getNetAssets(), true);
            netIncome.add(assetAllReportView.getYear() + "年", assetAllReportView.getNetIncome(), true);
            income.add(assetAllReportView.getYear() + "年", assetAllReportView.getIncome(), true);
            expense.add(assetAllReportView.getYear() + "年", assetAllReportView.getExpense(), true);
        }
        assetReportViewDtos.add(netAssets);
        assetReportViewDtos.add(netIncome);
        assetReportViewDtos.add(income);
        assetReportViewDtos.add(expense);
        return assetReportViewDtos;
    }


    @GetMapping("/asset/getYearReportData")
    @ResponseBody
    public List<AssetReportViewDto> getYearReportData(String year) {
        List<AssetYearReportView> assetYearReportViews = assetYearReportViewService.findByYearAndUsername(year + "%", SecurityUtils.getSubject().getPrincipal().toString());
        List<AssetReportViewDto> assetReportViewDtos = new ArrayList<>();
        AssetReportViewDto netAssets = new AssetReportViewDto("净资产");
        AssetReportViewDto netIncome = new AssetReportViewDto("净收入");
        AssetReportViewDto income = new AssetReportViewDto("收入");
        AssetReportViewDto expense = new AssetReportViewDto("支出");
        for (int i = 1; i < 13; i++) {
            boolean flag = false;
            for (AssetYearReportView assetYearReportView : assetYearReportViews) {
                int months = Integer.parseInt(assetYearReportView.getMonths().substring(assetYearReportView.getMonths().lastIndexOf("-") + 1));
                if (i == months) {
                    netAssets.add(i + "月", assetYearReportView.getNetAssets(), true);
                    netIncome.add(i + "月", assetYearReportView.getNetIncome(), true);
                    income.add(i + "月", assetYearReportView.getIncome(), true);
                    expense.add(i + "月", assetYearReportView.getExpense(), true);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                netAssets.add(i + "月", null, null);
                netIncome.add(i + "月", null, null);
                income.add(i + "月", null, null);
                expense.add(i + "月", null, null);
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
    public AssetReportViewDto getMonthsReportData(String yearMonths) {
        AssetYearReportView assetYearReportView = assetYearReportViewService.findByMonthsAndUsername(yearMonths, SecurityUtils.getSubject().getPrincipal().toString());
        AssetMain assetMain = new AssetMain();
        assetMain.setId(assetYearReportView.getId());
        List<AssetDetail> assetDetails = assetDetailService.findAllByAssetMainOrderByTypeDesc(assetMain);
        AssetReportViewDto assetReportViewDto = new AssetReportViewDto(yearMonths);
        for (AssetDetail assetDetail : assetDetails) {
            assetReportViewDto.add(assetDetail.getType() + "-" + assetDetail.getMessage(), assetDetail.getAmount(), false);
        }
        return assetReportViewDto;
    }


}
