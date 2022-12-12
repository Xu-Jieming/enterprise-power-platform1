package com.epp.pojo;

import lombok.Data;

@Data
public class Login {

    private String account;

    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String enterpriseName) {
        this.account = enterpriseName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
