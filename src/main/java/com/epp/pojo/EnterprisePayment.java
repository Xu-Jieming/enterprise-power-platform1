package com.epp.pojo;

import lombok.Data;
@Data
public class EnterprisePayment {
    private Integer enterprisePaymentId;

    private String enterpriseId;

    private String payment;

    private Integer year;

    private Integer month;

    private Integer status;

    public Integer getEnterprisePaymentId() {
        return enterprisePaymentId;
    }

    public void setEnterprisePaymentId(Integer enterprisePaymentId) {
        this.enterprisePaymentId = enterprisePaymentId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}