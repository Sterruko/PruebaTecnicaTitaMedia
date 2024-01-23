package com.titamedia.pruebaTecnica.mapper;

import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.entity.PaymentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto toPaymentDto(PaymentEntity paymentEntity);

    @InheritInverseConfiguration
    PaymentEntity toPaymentEntity(PaymentDto paymentDto);

    List<PaymentDto> toListDto(List<PaymentEntity> paymentEntity);

    @InheritInverseConfiguration
    List<PaymentEntity> toListEntity(List<PaymentDto> paymentDto);
}
