package com.epp.pojo;

import lombok.Data;

@Data
public class EnterpriseDailyPower {

    private Integer dailyPowerId;

    private Integer enterpriseId;

    private Integer enterpriseAccount;

    private double firstPeriodPower;

    private double secondPeriodPower;

    private double thirdPeriodPower;

    private double forthPeriodPower;

    private double dailyPower;

    private Integer year;

    private Integer month;

    private Integer day;


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

    public double getFirstPeriodPower() {
        return firstPeriodPower;
    }

    public void setFirstPeriodPower(double firstPeriodPower) {
        this.firstPeriodPower = firstPeriodPower ;
    }

    public double getSecondPeriodPower() {
        return secondPeriodPower;
    }

    public void setSecondPeriodPower(double secondPeriodPower) {
        this.secondPeriodPower = secondPeriodPower ;
    }

    public double getThirdPeriodPower() {
        return thirdPeriodPower;
    }

    public void setThirdPeriodPower(double thirdPeriodPower) {
        this.thirdPeriodPower = thirdPeriodPower ;
    }

    public double getForthPeriodPower() {
        return forthPeriodPower;
    }

    public void setForthPeriodPower(double forthPeriodPower) {
        this.forthPeriodPower = forthPeriodPower ;
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

    public void setTime(Integer year,Integer month,Integer day){this.year = year;this.month = month;this.day = day;}

    public double getDailyPower() {
        return dailyPower;
    }

    public void setDailyPower(double dailyPower) {
        this.dailyPower = dailyPower;
    }

    public Integer getDailyPowerId() {
        return dailyPowerId;
    }

    public void setDailyPowerId(Integer dailyPowerId) {
        this.dailyPowerId = dailyPowerId;
    }

}