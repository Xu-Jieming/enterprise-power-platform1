package com.epp.service.impl;

import com.epp.mapper.LoginMapper;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.Login;
import com.epp.service.LoginService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ApiResult login(Login login) {

        String account = login.getAccount();
        String password = login.getPassword();

        Admin adminRes = loginMapper.adminLogin(account, password);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "管理员登陆成功", adminRes);
        }

        Enterprise enterpriseRes = loginMapper.enterpriseLogin(account,password);
        if (enterpriseRes != null) {
            return ApiResultHandler.buildApiResult(200, "普通用户登陆成功", enterpriseRes);
        }
        return ApiResultHandler.buildApiResult(400, "登陆失败，请检查账号或者密码", null);
    }

    @Override
    public Admin adminLogin(String account, String password) {
        return loginMapper.adminLogin(account,password);
    }

    @Override
    public Enterprise enterpriseLogin(String account, String password) {
        return loginMapper.enterpriseLogin(account,password);
    }
}
