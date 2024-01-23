package com.titamedia.pruebaTecnica.service.business.impl;

import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.LoanDto;
import com.titamedia.pruebaTecnica.dto.PaymentDto;
import com.titamedia.pruebaTecnica.exception.LoanException;
import com.titamedia.pruebaTecnica.service.business.IProcessPaymentsService;
import com.titamedia.pruebaTecnica.service.dao.impl.LoanService;
import com.titamedia.pruebaTecnica.service.dao.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessPaymentsService implements IProcessPaymentsService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private LoanService loanService;

    @Override
    public List<LoanDetailDto> processPayment(PaymentDto paymentDto) throws LoanException {

        LoanDto loanDto = loanService.findById(paymentDto.getLoanId());
        int quota = loanDto.getQuotaValue() * paymentDto.getQuotaQuantity();

        if (loanDto.getTotalAmount() == 0) {
            throw new LoanException("No es posible realizar el pago porque la deuda no tiene saldo pendiente.");
        } else if (loanDto.getTotalAmount() < paymentDto.getAmount()) {
            throw new LoanException("No es posible realizar el pago porque el monto ingresado supera la deuda actual.");
        } else if (quota != paymentDto.getAmount()) {
            throw new LoanException("El monto ingresado no concuerda con la cantidad de cuotas a pagar.");
        } else {
            // Guardar el pago
            paymentService.save(paymentDto);

            // Actualizar el préstamo
            LoanDto updatedLoanDto = loanService.updateLoanById(paymentDto.getLoanId());

            // Calcular y actualizar las cuotas y el saldo total
            int totalQuota = updatedLoanDto.getTotalQuota() + paymentDto.getQuotaQuantity();
            int totalAmount = updatedLoanDto.getTotalAmount() - paymentDto.getAmount();

            updatedLoanDto.setTotalQuota(totalQuota);
            updatedLoanDto.setTotalAmount(totalAmount);

            loanService.save(updatedLoanDto);

            LoanDto loansDto = loanService.findById(paymentDto.getLoanId());

            if (loansDto.getTotalAmount() == 0) {
                LoanDto updatedStatusLoan = loanService.updateLoanById(paymentDto.getLoanId());

                updatedStatusLoan.setStatusId(2);
                loanService.save(updatedStatusLoan);
            }

            // Obtener y devolver los detalles del préstamo actualizado
            return loanService.getDetailsLoan(paymentDto.getLoanId());
        }
    }
}
