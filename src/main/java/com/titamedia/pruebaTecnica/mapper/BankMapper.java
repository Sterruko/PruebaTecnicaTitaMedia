package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.BankDto;
import com.titamedia.pruebaTecnica.dto.ListBankUserDto;
import com.titamedia.pruebaTecnica.entity.BankEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toBankDto(BankEntity bankEntity);

    @InheritInverseConfiguration
    BankEntity toBankEntity(BankDto bankDto);

    List<BankDto> toListDto(List<BankEntity> bankEntity);

    @InheritInverseConfiguration
    List<BankEntity> toListEntity(List<BankDto> contryDto);

    default ListBankUserDto mapToDto(Object[] result) {
        return new ListBankUserDto(
                (int) result[0],   // customerId
                (String) result[1],   // dni
                (String) result[2],   // name
                (int) result[3],   // bankId
                (String) result[4]);    // bankName
    }
}
