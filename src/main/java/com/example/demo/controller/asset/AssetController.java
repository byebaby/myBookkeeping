package com.example.demo.controller.asset;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;
import com.example.demo.entity.AssetModel;
import com.example.demo.entity.AssetView;
import com.example.demo.mapper.AccountingTipsMapper;
import com.example.demo.mapper.dto.AccountingTipsDto;
import com.example.demo.service.*;
import com.example.demo.vo.Json;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AssetController {
    private final UserService userService;
    private final AssetMainService assetMainService;
    private final AssetViewService assetViewService;
    private final AssetDetailService assetDetailService;
    private final AssetModelService assetModelService;
    private final AccountingTipsMapper accountingTipsMapper;

    public AssetController(AssetViewService assetViewService, AssetModelService assetModelService, AccountingTipsMapper accountingTipsMapper, AssetMainService assetMainService, UserService userService, AssetDetailService assetDetailService) {
        this.assetMainService = assetMainService;
        this.assetViewService = assetViewService;
        this.assetModelService = assetModelService;
        this.accountingTipsMapper = accountingTipsMapper;
        this.userService = userService;
        this.assetDetailService = assetDetailService;
    }

    /**
     * 表单模板配置页面
     *
     * @return
     */
    @GetMapping("/asset/defaultModel")
    public String defaultModel() {
        return "asset/defaultModel";
    }

    /**
     * 获取模板数据
     *
     * @return
     */
    @GetMapping("/asset/getModelData")
    @ResponseBody
    public Json getModelData() {
        List<AssetModel> tipsList = assetModelService.findByUsername(SecurityUtils.getSubject().getPrincipal().toString());
        List<AccountingTipsDto> dtos = accountingTipsMapper.toDTO(tipsList);
        return Json.succ("viewData", dtos).data("count", dtos.size());
    }

    /**
     * 表单模板配置保存
     *
     * @param assetModels
     * @return
     */
    @PostMapping("/asset/saveModelData")
    @ResponseBody
    public Json saveModelData(@RequestBody List<AssetModel> assetModels) {
        List<AssetModel> tipsList = assetModelService.save(assetModels);
        return Json.succ("viewData", tipsList).data("count", tipsList.size());
    }

    /**
     * 表单模板配置删除
     *
     * @param assetModels
     * @return
     */
    @PostMapping("/asset/delModelData")
    @ResponseBody
    public Json delModelData(@RequestBody List<AssetModel> assetModels) {

        assetModelService.del(assetModels);
        return Json.succ("deleteData").data("count", assetModels.size());
    }

    /**
     * 用户资产页面
     *
     * @return
     */
    @GetMapping("/asset/assetsView")
    public String assetsView() {
        return "asset/assetsView";
    }


    /**
     * 获取用户资产数据
     *
     * @return
     */
    @GetMapping("/asset/getAssetsViewData")
    @ResponseBody
    public Json getAssetsViewData() {
        List<AssetView> accountingViews = assetViewService.findViewDataByUserName(SecurityUtils.getSubject().getPrincipal().toString());
        return Json.succ("getAssetsViewData", accountingViews).data("count", accountingViews.size());
    }

    /**
     * 删除用户资产数据
     *
     * @param id
     * @return
     */
    @GetMapping("/asset/delAssetsViewData")
    @ResponseBody
    public Json delAssetsFormData(Long id) {
        assetMainService.deleteById(id);
        return Json.succ("delAssetsViewData");
    }

    /**
     * 用户资产数据 新增修改明细页面
     *
     * @param dataId
     * @param modelMap
     * @return
     */
    @GetMapping("/asset/assetsForm")
    public String assetsForm(Long dataId, ModelMap modelMap) {
        if (dataId != null) {
            modelMap.addAttribute("dataId", dataId);
        }
        return "asset/assetsForm";
    }

    /**
     * 保存用户资产明细数据
     *
     * @param assetMain
     * @return
     */
    @PostMapping("/asset/saveAssetsFormData")
    @ResponseBody
    public Json saveAssetsFormData(@RequestBody AssetMain assetMain) {
        assetMain.setUserId(userService.findUserByName(SecurityUtils.getSubject().getPrincipal().toString()).getId());
        assetMainService.save(assetMain);
        return Json.succ("saveDetail");
    }

    @PostMapping("/asset/deleteAssetsFormData")
    @ResponseBody
    public Json deleteAssetsFormData(@RequestBody List<AssetDetail> assetDetails) {
        assetDetailService.delAll(assetDetails);
        return Json.succ("deleteAssetsFormData");
    }

    /**
     * 获取用户资产明细接口
     *
     * @param id
     * @return
     */
    @GetMapping("/asset/getUserModelData")
    @ResponseBody
    public Json getUserModelData(Long id) {
        if (id == null) {
            List<AssetModel> assetModels = assetModelService.findByUserNameOrderByTypeDesc(SecurityUtils.getSubject().getPrincipal().toString());
            List<AccountingTipsDto> dtos = accountingTipsMapper.toDTOIgnoreId(assetModels);
            AssetMain assetMain = new AssetMain();
            assetMain.setAssetDetail(accountingTipsMapper.toAssetDetail(dtos));
            return Json.succ("viewData", assetMain).data("count", assetMain.getAssetDetail().size());
        } else {
            AssetMain assetMain = assetMainService.findById(id);
            return Json.succ("viewData", assetMain).data("count", assetMain.getAssetDetail().size());
        }


    }

}
