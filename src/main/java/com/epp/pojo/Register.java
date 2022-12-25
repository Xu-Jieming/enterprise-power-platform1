package com.epp.pojo;

import lombok.Data;

import lombok.Data;
@Data
import lombok.Data;
@Data
public class Register {


    private String enterpriseName;

    private String password;

    private String account;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
