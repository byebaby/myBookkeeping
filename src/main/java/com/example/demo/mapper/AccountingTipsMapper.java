package com.example.demo.mapper;

import com.example.demo.entity.AssetModel;
import com.example.demo.mapper.dto.AccountingTipsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountingTipsMapper {

    List<AccountingTipsDto> toDTO(List<AssetModel> accountingTips);
    @IterableMapping(qualifiedByName="toDTOIgnoreIdByOne")
    List<AccountingTipsDto> toDTOIgnoreId(List<AssetModel> accountingTips);

    List<AssetModel> toEntity(List<AccountingTipsDto> accountingTipsDto);

    @Named("toDTOIgnoreIdByOne")
    @Mapping(target = "id", ignore = true)
    AccountingTipsDto toDTOIgnoreIdByOne(AssetModel assetModel);
}
