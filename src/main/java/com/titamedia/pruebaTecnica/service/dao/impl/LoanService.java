package com.titamedia.pruebaTecnica.service.dao.impl;

import com.titamedia.pruebaTecnica.dto.ListLoansCustomerDto;
import com.titamedia.pruebaTecnica.dto.LoanDetailDto;
import com.titamedia.pruebaTecnica.dto.LoanDto;
import com.titamedia.pruebaTecnica.entity.LoanEntity;
import com.titamedia.pruebaTecnica.exception.LoanException;
import com.titamedia.pruebaTecnica.mapper.LoanMapper;
import com.titamedia.pruebaTecnica.repository.ILoanRepository;
import com.titamedia.pruebaTecnica.service.dao.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private LoanMapper loanMapper;
    @Autowired
    private ILoanRepository iLoanRepository;

    @Override
    public LoanDto save(LoanDto loanDto) throws LoanException {
        LoanDto loanSave = loanMapper.toLoanDto(
                iLoanRepository.save(loanMapper.toLoanEntity(loanDto)));
        return loanSave;
    }

    @Override
    public List<ListLoansCustomerDto> getListLoansCustomer(String dni, int bankId) throws LoanException {

        List<Object[]> result = iLoanRepository.getListLoansBank(dni, bankId);
        if (result.isEmpty()) {
            throw new LoanException("No existe información para el dni: " + dni + "y para el codigo de banco: " + bankId);
        }
        List<ListLoansCustomerDto> dtos = result.stream()
                .map(loanMapper::mapToListLoans)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<LoanDetailDto> getDetailsLoan(int loanId) throws LoanException {

        List<Object[]> result = iLoanRepository.getDetailsLoan(loanId);
        if (result.isEmpty()) {
            throw new LoanException("No existe información para el id: " + loanId);
        }
        List<LoanDetailDto> dtos = result.stream()
                .map(loanMapper::mapToDetailsLoan)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public LoanDto updateLoanById(int loanId) throws LoanException {

        Optional<LoanEntity> result = iLoanRepository.findById(loanId);
        return result.map(loanMapper::toLoanDto).orElse(null);
    }

    @Override
    public LoanDto findById(int loanId) throws LoanException {
        Optional<LoanEntity> result = iLoanRepository.findById(loanId);

        if (result.isPresent()) {
            return loanMapper.toLoanDto(result.get());
        } else {
            throw new LoanException("No existe información para el id: " + loanId);
        }
    }


}
