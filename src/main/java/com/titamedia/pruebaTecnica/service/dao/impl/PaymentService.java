package com.titamedia.pruebaTecnica.service.dao.impl;

import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.mapper.PaymentMapper;
import com.titamedia.pruebaTecnica.repository.IPaymentRepository;
import com.titamedia.pruebaTecnica.service.dao.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private IPaymentRepository iPaymentRepository;

    @Override
    public PaymentDto save(PaymentDto paymentDto) {

        PaymentDto paymentSave = new PaymentDto();
        paymentSave.setLoanId(paymentDto.getLoanId());
        paymentSave.setAmount(paymentDto.getAmount());
        paymentSave.setQuotaQuantity(paymentDto.getQuotaQuantity());

        paymentSave = paymentMapper.toPaymentDto(
                iPaymentRepository.save(paymentMapper.toPaymentEntity(paymentDto)));
        return paymentSave;
    }
}
