package com.epp.pojo;

import lombok.Data;

@Data
public class EnterprisePower {

    private Integer enterprisePowerId;

    private Integer enterpriseId;

    private double firstRatePower;

    private double secondRatePower;

    private double thirdRatePower;

    private double sumPower;

    private Integer year;

    private Integer month;


    public Integer getEnterprisePowerId() {
        return enterprisePowerId;
    }

    public void setEnterprisePowerId(Integer enterprisePowerId) {
        this.enterprisePowerId = enterprisePowerId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public double getFirstRatePower() {
        return firstRatePower;
    }

    public void setFirstRatePower(double firstRatePower) {
        this.firstRatePower = firstRatePower;
    }

    public double getSecondRatePower() {
        return secondRatePower;
    }

    public void setSecondRatePower(double secondRatePower) {
        this.secondRatePower = secondRatePower;
    }

    public double getThirdRatePower() {
        return thirdRatePower;
    }

    public void setThirdRatePower(double thirdRatePower) {
        this.thirdRatePower = thirdRatePower;
    }

    public double getSumPower() {
        return sumPower;
    }

    public void setSumPower(double sumPower) {
        this.sumPower = sumPower;
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

    public void setTime(Integer year,Integer month) {
        this.year = year;
        this.month = month;
    }
}