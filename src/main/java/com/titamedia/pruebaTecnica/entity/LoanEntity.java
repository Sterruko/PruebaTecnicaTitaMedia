package com.titamedia.pruebaTecnica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class LoanEntity {
    @Id
    @JsonIgnore
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "bank_id")
    private int bankId;
    @Column(name = "total_amount")
    private int totalAmount;
    @Column(name = "quota_value")
    private int quotaValue;
    @Column(name = "quota_amount")
    private int quotaAmount;
    @Column(name = "total_quota")
    private int totalQuota;
    @Column(name = "status_id")
    private int statusId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getQuotaValue() {
        return quotaValue;
    }

    public void setQuotaValue(int quotaValue) {
        this.quotaValue = quotaValue;
    }
}
