package com.titamedia.pruebaTecnica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    private int id;
    @Column(name = "loan_id")
    private int loanId;
    private int amount;
    @Column(name = "quota_quantity")
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
