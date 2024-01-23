package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.entity.PaymentEntity;
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
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toPaymentDto(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId( paymentEntity.getId() );
        paymentDto.setLoanId( paymentEntity.getLoanId() );
        paymentDto.setAmount( paymentEntity.getAmount() );
        paymentDto.setQuotaQuantity( paymentEntity.getQuotaQuantity() );

        return paymentDto;
    }

    @Override
    public PaymentEntity toPaymentEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setId( paymentDto.getId() );
        paymentEntity.setLoanId( paymentDto.getLoanId() );
        paymentEntity.setAmount( paymentDto.getAmount() );
        paymentEntity.setQuotaQuantity( paymentDto.getQuotaQuantity() );

        return paymentEntity;
    }

    @Override
    public List<PaymentDto> toListDto(List<PaymentEntity> paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        List<PaymentDto> list = new ArrayList<PaymentDto>( paymentEntity.size() );
        for ( PaymentEntity paymentEntity1 : paymentEntity ) {
            list.add( toPaymentDto( paymentEntity1 ) );
        }

        return list;
    }

    @Override
    public List<PaymentEntity> toListEntity(List<PaymentDto> paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        List<PaymentEntity> list = new ArrayList<PaymentEntity>( paymentDto.size() );
        for ( PaymentDto paymentDto1 : paymentDto ) {
            list.add( toPaymentEntity( paymentDto1 ) );
        }

        return list;
    }
}
