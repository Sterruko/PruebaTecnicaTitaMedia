package com.titamedia.pruebaTecnica.service.dao;

import com.titamedia.pruebaTecnica.dto.ListLoansCustomerDto;
import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.LoanDto;
import com.titamedia.pruebaTecnica.exception.LoanException;

import java.util.List;

public interface ILoanService {

    LoanDto save(LoanDto loanDto) throws LoanException;

    List<ListLoansCustomerDto> getListLoansCustomer(String dni, int bankId) throws LoanException;

    List<LoanDetailDto> getDetailsLoan(int loanId) throws LoanException;

    LoanDto updateLoanById(int loanId) throws LoanException;

    LoanDto findById(int loanId) throws LoanException;
}
