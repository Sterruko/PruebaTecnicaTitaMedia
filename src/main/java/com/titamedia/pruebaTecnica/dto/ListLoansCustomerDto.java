package com.titamedia.pruebaTecnica.dto;

public class ListLoansCustomerDto {
    private int loanId;
    private int customerId;
    private int bankId;
    private String nitBank;
    private String nameBank;
    private int totalAmount;
    private int quotaValue;
    private int quotaAmount;
    private int totalQuota;
    private String status;

    public ListLoansCustomerDto(int loanId, int customerId, int bankId, String nitBank, String nameBank, int totalAmount, int quotaValue, int quotaAmount, int totalQuota, String status) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.bankId = bankId;
        this.nitBank = nitBank;
        this.nameBank = nameBank;
        this.totalAmount = totalAmount;
        this.quotaValue = quotaValue;
        this.quotaAmount = quotaAmount;
        this.totalQuota = totalQuota;
        this.status = status;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getNitBank() {
        return nitBank;
    }

    public void setNitBank(String nitBank) {
        this.nitBank = nitBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getQuotaValue() {
        return quotaValue;
    }

    public void setQuotaValue(int quotaValue) {
        this.quotaValue = quotaValue;
    }

    public int getQuotaAmount() {
        return quotaAmount;
    }

    public void setQuotaAmount(int quotaAmount) {
        this.quotaAmount = quotaAmount;
    }

    public int getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(int totalQuota) {
        this.totalQuota = totalQuota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
