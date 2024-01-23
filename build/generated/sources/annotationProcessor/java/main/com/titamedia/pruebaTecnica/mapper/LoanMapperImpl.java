package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.LoanDto;
import com.titamedia.pruebaTecnica.entity.LoanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T10:30:41-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanDto toLoanDto(LoanEntity loanEntity) {
        if ( loanEntity == null ) {
            return null;
        }

        LoanDto loanDto = new LoanDto();

        loanDto.setId( loanEntity.getId() );
        loanDto.setCustomerId( loanEntity.getCustomerId() );
        loanDto.setBankId( loanEntity.getBankId() );
        loanDto.setTotalAmount( loanEntity.getTotalAmount() );
        loanDto.setQuotaAmount( loanEntity.getQuotaAmount() );
        loanDto.setTotalQuota( loanEntity.getTotalQuota() );
        loanDto.setStatusId( loanEntity.getStatusId() );
        loanDto.setQuotaValue( loanEntity.getQuotaValue() );

        return loanDto;
    }

    @Override
    public LoanEntity toLoanEntity(LoanDto loanDto) {
        if ( loanDto == null ) {
            return null;
        }

        LoanEntity loanEntity = new LoanEntity();

        loanEntity.setId( loanDto.getId() );
        loanEntity.setCustomerId( loanDto.getCustomerId() );
        loanEntity.setBankId( loanDto.getBankId() );
        loanEntity.setTotalAmount( loanDto.getTotalAmount() );
        loanEntity.setQuotaAmount( loanDto.getQuotaAmount() );
        loanEntity.setTotalQuota( loanDto.getTotalQuota() );
        loanEntity.setStatusId( loanDto.getStatusId() );
        loanEntity.setQuotaValue( loanDto.getQuotaValue() );

        return loanEntity;
    }

    @Override
    public List<LoanDto> toListDto(List<LoanEntity> loanEntity) {
        if ( loanEntity == null ) {
            return null;
        }

        List<LoanDto> list = new ArrayList<LoanDto>( loanEntity.size() );
        for ( LoanEntity loanEntity1 : loanEntity ) {
            list.add( toLoanDto( loanEntity1 ) );
        }

        return list;
    }

    @Override
    public List<LoanEntity> toListEntity(List<LoanDto> loanDto) {
        if ( loanDto == null ) {
            return null;
        }

        List<LoanEntity> list = new ArrayList<LoanEntity>( loanDto.size() );
        for ( LoanDto loanDto1 : loanDto ) {
            list.add( toLoanEntity( loanDto1 ) );
        }

        return list;
    }
}
