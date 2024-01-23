package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.ListLoansCustomerDto;
import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.LoanDto;
import com.titamedia.pruebaTecnica.entity.LoanEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    LoanDto toLoanDto(LoanEntity loanEntity);

    @InheritInverseConfiguration
    LoanEntity toLoanEntity(LoanDto loanDto);

    List<LoanDto> toListDto(List<LoanEntity> loanEntity);

    @InheritInverseConfiguration
    List<LoanEntity> toListEntity(List<LoanDto> loanDto);

    default ListLoansCustomerDto mapToListLoans(Object[] result) {
        return new ListLoansCustomerDto(
                (int) result[0],   // LoanId
                (int) result[1],   // customerId
                (int) result[2],   // bankId
                (String) result[3],   // nitBank
                (String) result[4],   // nameBank
                (int) result[5],      // totalAmount
                (int) result[6],   // quotaValue
                (int) result[7],   //quotaAmount
                (int) result[8],   // totalQuota
                (String) result[9]);   // status
    }

    default LoanDetailDto mapToDetailsLoan(Object[] result) {
        return new LoanDetailDto(
                (int) result[0],   // LoanId
                (int) result[1],   // customerId
                (int) result[2],   // bankId
                (String) result[3],   // nitBank
                (String) result[4],   // nameBank
                (int) result[5],      // totalAmount
                (int) result[6],   // totalQuota
                (String) result[7]);   // status
    }
}
