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
        AssetReportViewDto assetReportViewDto = new AssetReportViewDto();
        assetReportViewDto.setName("净资产");
        for (AssetReportView assetReportView : assetReportViews) {
            assetReportViewDto.getData().add(assetReportView.getNetAssets());
        }
        assetReportViewDtos.add(assetReportViewDto);
        AssetReportViewDto assetReportViewDto1 = new AssetReportViewDto();
        assetReportViewDto1.setName("净收入");
        for (AssetReportView assetReportView : assetReportViews) {
            assetReportViewDto1.getData().add(assetReportView.getNetIncome());
        }
        assetReportViewDtos.add(assetReportViewDto1);
        AssetReportViewDto assetReportViewDto2 = new AssetReportViewDto();
        assetReportViewDto2.setName("收入");
        for (AssetReportView assetReportView : assetReportViews) {
            assetReportViewDto2.getData().add(assetReportView.getIncome());
        }
        assetReportViewDtos.add(assetReportViewDto2);
        AssetReportViewDto assetReportViewDto3 = new AssetReportViewDto();
        assetReportViewDto3.setName("支出");
        for (AssetReportView assetReportView : assetReportViews) {
            assetReportViewDto3.getData().add(assetReportView.getExpense());
        }
        assetReportViewDtos.add(assetReportViewDto3);
        return assetReportViewDtos;
    }
}
