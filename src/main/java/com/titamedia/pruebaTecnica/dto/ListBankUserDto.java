package com.titamedia.pruebaTecnica.dto;

public class ListBankUserDto {

    private int customerId;
    private String dni;
    private String name;
    private int bankId;
    private String bankName;

    public ListBankUserDto(int customerId, String dni, String name, int bankId, String bankName) {
        this.customerId = customerId;
        this.dni = dni;
        this.name = name;
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
