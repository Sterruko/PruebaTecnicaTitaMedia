package com.titamedia.pruebaTecnica.service.dao.impl;

import com.titamedia.pruebaTecnica.dto.ListBankUserDto;
import com.titamedia.pruebaTecnica.exception.CustomerException;
import com.titamedia.pruebaTecnica.mapper.BankMapper;
import com.titamedia.pruebaTecnica.repository.ICustomerRepository;
import com.titamedia.pruebaTecnica.service.dao.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private BankMapper bankMapper;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<ListBankUserDto> getBankToUser(String dni) throws CustomerException {

        List<Object[]> result = iCustomerRepository.getBankToUser(dni);
        if (result.isEmpty()) {
            throw new CustomerException("No existe información para el dni: " + dni);
        }
        List<ListBankUserDto> dtos = result.stream()
                .map(bankMapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }
}
