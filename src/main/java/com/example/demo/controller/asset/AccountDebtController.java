package com.example.demo.controller.asset;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetModel;
import com.example.demo.entity.AssetView;
import com.example.demo.service.AssetDetailService;
import com.example.demo.service.AssetModelService;
import com.example.demo.service.AssetViewService;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
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
    private final AssetViewService assetViewService;
    private final AssetDetailService assetDetailService;
    private final AssetModelService assetModelService;

    public AccountDebtController(AssetViewService assetViewService, AssetDetailService assetDetailService, AssetModelService assetModelService) {
        this.assetViewService = assetViewService;
        this.assetDetailService = assetDetailService;
        this.assetModelService = assetModelService;
    }

    /**
     * 表单模板配置
     *
     * @return
     */
    @GetMapping("/asset/model")
    public String getAssetModel() {
        return "/asset/defaultModel";
    }

    /**
     * 表单模板配置保存
     * @param tips
     * @return
     */
    @PostMapping("/asset/modelData")
    @ResponseBody
    public Json saveModelData(@RequestBody List<AssetModel> tips) {
        List<AssetModel> tipsList = assetModelService.save(tips);
        return Json.succ("viewData", tipsList).data("count", tipsList.size());
    }

    /**
     * 用户资产台账
     *
     * @return
     */
    @GetMapping("/asset/assetsView")
    public String getDebt() {
        return "/asset/assetsView";
    }

    /**
     * 用户资产明细
     *
     * @param id
     * @param modelMap
     * @return
     */
    @GetMapping("/account/assetsDebtForm")
    public String getAddForm(Long id, ModelMap modelMap) {
        if (id != null) {
            modelMap.addAttribute("id", id);
        }
        return "/asset/assetsDebtForm";
    }

    /**
     * @param date
     * @param data
     * @return
     */
    @PostMapping("/account/assetsDebtForm")
    @ResponseBody
    public Json saveAddForm(String date, @RequestBody List<AssetDetail> data) {
        assetDetailService.save(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), data);
        return Json.succ("saveDetail");
    }


    @GetMapping("/account/accountingViewData")
    @ResponseBody
    public Json getAccountingViewData() {
        List<AssetView> accountingViews = assetViewService.findViewDataByUserName(SecurityUtils.getSubject().getPrincipal().toString());
        return Json.succ("viewData", accountingViews).data("count", accountingViews.size());
    }
}
