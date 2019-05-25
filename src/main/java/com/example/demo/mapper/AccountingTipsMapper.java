package com.example.demo.mapper;

import com.example.demo.entity.AccountingTips;
import com.example.demo.mapper.dto.AccountingTipsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountingTipsMapper {

    List<AccountingTipsDto> toDTO(List<AccountingTips> accountingTips);
    @IterableMapping(qualifiedByName="toDTOIgnoreIdByOne")
    List<AccountingTipsDto> toDTOIgnoreId(List<AccountingTips> accountingTips);

    List<AccountingTips> toEntity(List<AccountingTipsDto> accountingTipsDto);

    @Named("toDTOIgnoreIdByOne")
    @Mapping(target = "id", ignore = true)
    AccountingTipsDto toDTOIgnoreIdByOne(AccountingTips accountingTips);
}
