package com.titamedia.pruebaTecnica.service.business;


import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.exception.LoanException;
import com.titamedia.pruebaTecnica.exception.PaymentException;

import java.util.List;

public interface IProcessPaymentsService {
    List<LoanDetailDto> processPayment(PaymentDto paymentDto) throws PaymentException, LoanException;
}
