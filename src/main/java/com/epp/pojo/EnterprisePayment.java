package com.epp.pojo;

import lombok.Data;
@Data
public class EnterprisePayment {
    private Integer enterprisePaymentId;

    private Integer enterpriseId;

    private double firstRatePayment;

    private double secondRatePayment;

    private  double thirdRatePayment;

    private double sumRatePayment;

    private Integer year;

    private Integer month;

    private Integer status;

    public Integer getEnterprisePaymentId() {
        return enterprisePaymentId;
    }

    public void setEnterprisePaymentId(Integer enterprisePaymentId) {
        this.enterprisePaymentId = enterprisePaymentId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId ;
    }

    public double getFirstRatePayment() {
        return firstRatePayment;
    }

    public void setFirstRatePayment(double firstRatePayment) {
        this.firstRatePayment = firstRatePayment;
    }

    public double getSecondRatePayment() {
        return secondRatePayment;
    }

    public void setSecondRatePayment(double secondRatePayment) {
        this.secondRatePayment = secondRatePayment;
    }

    public double getThirdRatePayment() {
        return thirdRatePayment;
    }

    public void setThirdRatePayment(double thirdRatePayment) {
        this.thirdRatePayment = thirdRatePayment;
    }

    public double getSumRatePayment() {
        return sumRatePayment;
    }

    public void setSumRatePayment(double sumRatePayment) {
        this.sumRatePayment = sumRatePayment;
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

    public void setTime(Integer year,Integer month) {
        this.year = year;this.month = month;
    }

}