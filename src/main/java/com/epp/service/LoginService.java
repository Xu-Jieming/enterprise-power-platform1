package com.epp.service;


import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Login;

public interface LoginService {

    public ApiResult login(Login login);

    public Admin adminLogin(String username, String password);



}
