package com.titamedia.pruebaTecnica.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PaymentDto {

    @JsonIgnore
    private int id;
    private int loanId;
    private int amount;
    private int quotaQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuotaQuantity() {
        return quotaQuantity;
    }

    public void setQuotaQuantity(int quotaQuantity) {
        this.quotaQuantity = quotaQuantity;
    }

}
