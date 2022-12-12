package com.epp.controller;


import com.epp.pojo.ApiResult;
import com.epp.pojo.Login;
import com.epp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login){
        return loginService.login(login);
    }
}
