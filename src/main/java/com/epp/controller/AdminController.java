package com.epp.controller;

import com.epp.pojo.ApiResult;
import com.epp.pojo.Admin;
import com.epp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return adminService.selectAll();
    }

    @GetMapping("/admin/{account}")
    public ApiResult selectByAccount(@PathVariable("adminId")Integer account){
        //System.out.println("根据账号查找管理员");
        return adminService.selectByAccount(account);
    }

    @DeleteMapping("/admin/{account}")
    public ApiResult deleteByAccount(@PathVariable("adminId")Integer account){
        //System.out.println("根据账号删除管理员");
        return adminService.deleteByAccount(account);
    }

    @PutMapping("/admin")
    public ApiResult update(@RequestBody Admin admin){
        //System.out.println("修改管理员");
        return adminService.update(admin);
    }

    @PostMapping("/admin")
    public ApiResult insert(@RequestBody Admin admin){
        //System.out.println("添加管理员");
        return adminService.insert(admin);
    }
}
