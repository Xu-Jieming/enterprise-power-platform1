package com.epp.pojo;

import lombok.Data;
@Data
public class BranchSet {
    private Integer branchId;

    private Integer enterpriseId;

    private Integer firstBranchSet;

    private Integer secondBranchSet;

    private Integer thirdBranchSet;

    private Integer forthBranchSet;

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

    public Integer getFirstBranchSet() {
        return firstBranchSet;
    }

    public void setFirstBranchSet(Integer firstBranchSet) {
        this.firstBranchSet = firstBranchSet;
    }

    public Integer getSecondBranchSet() {
        return secondBranchSet;
    }

    public void setSecondBranchSet(Integer secondBranchSet) {
        this.secondBranchSet = secondBranchSet;
    }

    public Integer getThirdBranchSet() {
        return thirdBranchSet;
    }

    public void setThirdBranchSet(Integer thirdBranchSet) {
        this.thirdBranchSet = thirdBranchSet;
    }

    public Integer getForthBranchSet() {
        return forthBranchSet;
    }

    public void setForthBranchSet(Integer forthBranchSet) {
        this.forthBranchSet = forthBranchSet;
    }
}