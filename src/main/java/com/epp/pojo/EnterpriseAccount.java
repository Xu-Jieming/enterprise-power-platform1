package com.epp.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/27/1:01
 * @Description:
 */
public class EnterpriseAccount {

    private Integer enterpriseAccountId;

    private Integer enterpriseId;

    private double currentAccount;

    public Integer getEnterpriseAccountId() {
        return enterpriseAccountId;
    }

    public void setEnterpriseAccountId(Integer enterpriseAccountId) {
        this.enterpriseAccountId = enterpriseAccountId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(double currentAccount) {
        this.currentAccount = currentAccount;
    }
}
