package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.BankDto;
import com.titamedia.pruebaTecnica.entity.BankEntity;
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
public class BankMapperImpl implements BankMapper {

    @Override
    public BankDto toBankDto(BankEntity bankEntity) {
        if ( bankEntity == null ) {
            return null;
        }

        BankDto bankDto = new BankDto();

        bankDto.setId( bankEntity.getId() );
        bankDto.setDocumentNumber( bankEntity.getDocumentNumber() );
        bankDto.setName( bankEntity.getName() );

        return bankDto;
    }

    @Override
    public BankEntity toBankEntity(BankDto bankDto) {
        if ( bankDto == null ) {
            return null;
        }

        BankEntity bankEntity = new BankEntity();

        bankEntity.setId( bankDto.getId() );
        bankEntity.setDocumentNumber( bankDto.getDocumentNumber() );
        bankEntity.setName( bankDto.getName() );

        return bankEntity;
    }

    @Override
    public List<BankDto> toListDto(List<BankEntity> bankEntity) {
        if ( bankEntity == null ) {
            return null;
        }

        List<BankDto> list = new ArrayList<BankDto>( bankEntity.size() );
        for ( BankEntity bankEntity1 : bankEntity ) {
            list.add( toBankDto( bankEntity1 ) );
        }

        return list;
    }

    @Override
    public List<BankEntity> toListEntity(List<BankDto> contryDto) {
        if ( contryDto == null ) {
            return null;
        }

        List<BankEntity> list = new ArrayList<BankEntity>( contryDto.size() );
        for ( BankDto bankDto : contryDto ) {
            list.add( toBankEntity( bankDto ) );
        }

        return list;
    }
}
