package com.epp.pojo;

import lombok.Data;
@Data
public class BranchPower {
    private Integer branchPowerId;

    private Integer branchId;

    private Integer enterpriseId;

    private Double firstBranchPower;

    private Double secondBranchPower;

    private Double thirdBranchPower;

    private Double forthBranchPower;

    private Integer year;

    private Integer month;

    private Integer day;

    public Integer getBranchPowerId() {
        return branchPowerId;
    }

    public void setBranchPowerId(Integer branchPowerId) {
        this.branchPowerId = branchPowerId;
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

    public Double getFirstBranchPower() {
        return firstBranchPower;
    }

    public void setFirstBranchPower(Double firstBranchPower) {
        this.firstBranchPower = firstBranchPower;
    }

    public Double getSecondBranchPower() {
        return secondBranchPower;
    }

    public void setSecondBranchPower(Double secondBranchPower) {
        this.secondBranchPower = secondBranchPower;
    }

    public Double getThirdBranchPower() {
        return thirdBranchPower;
    }

    public void setThirdBranchPower(Double thirdBranchPower) {
        this.thirdBranchPower = thirdBranchPower;
    }

    public Double getForthBranchPower() {
        return forthBranchPower;
    }

    public void setForthBranchPower(Double forthBranchPower) {
        this.forthBranchPower = forthBranchPower;
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