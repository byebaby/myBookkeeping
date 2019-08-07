package com.example.demo.mapper;

import com.example.demo.entity.asset.AssetDetail;
import com.example.demo.entity.asset.AssetModel;
import com.example.demo.mapper.dto.AccountingModelDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountingModelMapper {

    List<AccountingModelDto> toDTO(List<AssetModel> accountingTips);
    @IterableMapping(qualifiedByName="toDTOIgnoreIdByOne")
    List<AccountingModelDto> toDTOIgnoreId(List<AssetModel> accountingTips);

    List<AssetDetail> toAssetDetail(List<AccountingModelDto> accountingModelDto);

    @Named("toDTOIgnoreIdByOne")
    @Mapping(target = "id", ignore = true)
    AccountingModelDto toDTOIgnoreIdByOne(AssetModel assetModel);
}
