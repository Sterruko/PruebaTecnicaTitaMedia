package com.titamedia.pruebaTecnica.controller;

import com.titamedia.pruebaTecnica.dto.ErrorResponse;
import com.titamedia.pruebaTecnica.dto.ListLoansCustomerDto;
import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.exception.LoanException;
import com.titamedia.pruebaTecnica.service.dao.impl.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/getListLoansToBank")
    public ResponseEntity<?> getListLoansToBank(@RequestParam(name = "dni") String dni,
                                                @RequestParam(name = "bankId") int bankId) {
        try {
            List<ListLoansCustomerDto> loans = loanService.getListLoansCustomer(dni, bankId);
            return ResponseEntity.ok(loans);
        } catch (LoanException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/getDetailsLoan")
    public ResponseEntity<?> getDetailsLoan(@RequestParam(name = "loanId") int loanId) {
        try {
            List<LoanDetailDto> loanDetails = loanService.getDetailsLoan(loanId);
            return ResponseEntity.ok(loanDetails);
        } catch (LoanException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }
}
