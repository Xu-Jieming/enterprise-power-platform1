package com.epp.pojo;

import lombok.Data;
@Data
public class HourlyPower {
    private Integer hourId;

    private Integer branchId;

    private Integer enterpriseId;

    private Double firstPeriodPower;

    private Double doublePeriodPower;

    private Double thirdPeriodPower;

    private Double forthPeriodPower;

    private Integer branchSet;

    private Integer day;

    private Integer month;

    private Integer year;

    public Integer getHourId() {
        return hourId;
    }

    public void setHourId(Integer hourId) {
        this.hourId = hourId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Double getFirstPeriodPower() {
        return firstPeriodPower;
    }

    public void setFirstPeriodPower(Double firstPeriodPower) {
        this.firstPeriodPower = firstPeriodPower;
    }

    public Double getDoublePeriodPower() {
        return doublePeriodPower;
    }

    public void setDoublePeriodPower(Double doublePeriodPower) {
        this.doublePeriodPower = doublePeriodPower;
    }

    public Double getThirdPeriodPower() {
        return thirdPeriodPower;
    }

    public void setThirdPeriodPower(Double thirdPeriodPower) {
        this.thirdPeriodPower = thirdPeriodPower;
    }

    public Double getForthPeriodPower() {
        return forthPeriodPower;
    }

    public void setForthPeriodPower(Double forthPeriodPower) {
        this.forthPeriodPower = forthPeriodPower;
    }

    public Integer getBranchSet() {
        return branchSet;
    }

    public void setBranchSet(Integer branchSet) {
        this.branchSet = branchSet;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}