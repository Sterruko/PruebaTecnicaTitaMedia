package com.titamedia.pruebaTecnica.service.dao;

import com.titamedia.pruebaTecnica.dto.ListBankUserDto;
import com.titamedia.pruebaTecnica.exception.CustomerException;

import java.util.List;

public interface ICustomerService {
    List<ListBankUserDto> getBankToUser(String dni) throws CustomerException;
}
