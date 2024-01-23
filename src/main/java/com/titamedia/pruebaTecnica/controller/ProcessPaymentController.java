package com.titamedia.pruebaTecnica.controller;

import com.titamedia.pruebaTecnica.dto.ErrorResponse;
import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.exception.LoanException;
import com.titamedia.pruebaTecnica.service.business.impl.ProcessPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payment")
public class ProcessPaymentController {
    @Autowired
    private ProcessPaymentsService processPaymentsService;

    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestBody PaymentDto paymentDto) {
        try {
            List<LoanDetailDto> savedPaymentDto = processPaymentsService.processPayment(paymentDto);
            return ResponseEntity.ok(savedPaymentDto);
        } catch (LoanException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

}
