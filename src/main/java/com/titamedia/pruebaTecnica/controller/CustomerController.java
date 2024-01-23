package com.titamedia.pruebaTecnica.controller;

import com.titamedia.pruebaTecnica.dto.ErrorResponse;
import com.titamedia.pruebaTecnica.dto.ListBankUserDto;
import com.titamedia.pruebaTecnica.exception.CustomerException;
import com.titamedia.pruebaTecnica.service.dao.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getBanksForUser")
    public ResponseEntity<?> getBanksForUser(@RequestParam(name = "dni") String dni) {
        try {
            List<ListBankUserDto> banks = customerService.getBankToUser(dni);
            return ResponseEntity.ok(banks);
        } catch (CustomerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }
}

