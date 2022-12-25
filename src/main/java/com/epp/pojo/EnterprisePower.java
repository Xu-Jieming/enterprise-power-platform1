package com.epp.pojo;

import lombok.Data;
@Data
public class EnterprisePower {
    private Integer enterprisePowerId;

    private Integer enterpriseId;

    private Integer enterpriseAccount;

    private String firstPeriodPower;

    private String secondPeriodPower;

    private String thirdPeriodPower;

    private String forthPeriodPower;

    private Integer year;

    private Integer month;

    private Integer day;

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

    public Integer getEnterpriseAccount() {
        return enterpriseAccount;
    }

    public void setEnterpriseAccount(Integer enterpriseAccount) {
        this.enterpriseAccount = enterpriseAccount;
    }

    public String getFirstPeriodPower() {
        return firstPeriodPower;
    }

    public void setFirstPeriodPower(String firstPeriodPower) {
        this.firstPeriodPower = firstPeriodPower == null ? null : firstPeriodPower.trim();
    }

    public String getSecondPeriodPower() {
        return secondPeriodPower;
    }

    public void setSecondPeriodPower(String secondPeriodPower) {
        this.secondPeriodPower = secondPeriodPower == null ? null : secondPeriodPower.trim();
    }

    public String getThirdPeriodPower() {
        return thirdPeriodPower;
    }

    public void setThirdPeriodPower(String thirdPeriodPower) {
        this.thirdPeriodPower = thirdPeriodPower == null ? null : thirdPeriodPower.trim();
    }

    public String getForthPeriodPower() {
        return forthPeriodPower;
    }

    public void setForthPeriodPower(String forthPeriodPower) {
        this.forthPeriodPower = forthPeriodPower == null ? null : forthPeriodPower.trim();
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}