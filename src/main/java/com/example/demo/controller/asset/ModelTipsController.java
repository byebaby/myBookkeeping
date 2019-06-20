package com.example.demo.controller.asset;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetModel;
import com.example.demo.mapper.AccountingTipsMapper;
import com.example.demo.mapper.dto.AccountingTipsDto;
import com.example.demo.service.AssetMainService;
import com.example.demo.service.AssetModelService;
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
    private final AssetModelService assetModelService;
    private final AssetMainService assetMainService;

    public ModelTipsController(AccountingTipsMapper accountingTipsMapper, AssetModelService assetModelService, AssetMainService assetMainService) {
        this.accountingTipsMapper = accountingTipsMapper;
        this.assetModelService = assetModelService;
        this.assetMainService = assetMainService;
    }


    @GetMapping("/account/ModelTipsData")
    @ResponseBody
    public Json getModelTipsData() {
        List<AssetModel> tipsList = assetModelService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        List<AccountingTipsDto> dtos = accountingTipsMapper.toDTO(tipsList);
        return Json.succ("viewData", dtos).data("count", dtos.size());

    }

    @GetMapping("/account/ModelTipsDataIgnore")
    @ResponseBody
    public Json getModelTipsDataIgnore(Long id) {
        List<AssetModel> tipsList = assetModelService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        if (id == null) {
            List<AccountingTipsDto> dtos = accountingTipsMapper.toDTOIgnoreId(tipsList);
            return Json.succ("viewData", dtos).data("count", dtos.size());
        } else {
            List<AssetDetail> details = assetMainService.findById(id).getAssetDetail();
            return Json.succ("viewData", details).data("count", details.size());
        }


    }

    @PostMapping("/account/ModelTipsData")
    @ResponseBody
    public Json postModelTipsData(@RequestBody List<AssetModel> tips) {
        List<AssetModel> tipsList = assetModelService.save(tips);
        return Json.succ("viewData", accountingTipsMapper.toDTOIgnoreId(tipsList)).data("count", tipsList.size());
    }


    @PostMapping("/account/ModelTipsDataDelete")
    @ResponseBody
    public Json deleteModelTipsData(@RequestBody List<AssetModel> tips) {

        assetModelService.del(tips);
        return Json.succ("deleteData");
    }
}
