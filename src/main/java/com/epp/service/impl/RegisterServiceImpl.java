package com.epp.service.impl;


import com.epp.mapper.RegisterMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.pojo.Register;
import com.epp.service.RegisterService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public ApiResult enterpriseRegister(Register register) {

        Enterprise existEnterprise = registerMapper.findEnterpriseByName(register.getEnterpriseName());
        if (existEnterprise != null){
            return ApiResultHandler.buildApiResult(400,"用户名已存在，请重新输入",null);
        }if (existEnterprise == null){

            Random random = new Random();
            String result="";
            for (int i=0;i<6;i++)
            {
                result+=random.nextInt(10);
            }
            register.setAccount(result);
            registerMapper.regist(register);
            return ApiResultHandler.buildApiResult(200,"请求成功，注册成功",register);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败",null);
    }
}
