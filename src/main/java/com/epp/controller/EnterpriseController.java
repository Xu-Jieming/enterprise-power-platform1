package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Enterprise;
import com.epp.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;


    @GetMapping("/enterprise/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部企业");
        Page<Enterprise> enterprisePage = new Page<>(page,size);
        return enterpriseService.selectAll(enterprisePage);
    }


    @GetMapping("/enterprise/{enterpriseId}")
    public ApiResult selectByPrimaryKey(@PathVariable("enterpriseId")Integer enterpriseId){
        //System.out.println("根据ID查找企业");
        return enterpriseService.selectByPrimaryKey(enterpriseId);
    }

    @GetMapping("/enterprise/{account}")
    public ApiResult selectByAccount(@PathVariable("enterpriseId")Integer account){
        //System.out.println("根据账号查找企业");
        return enterpriseService.selectByAccount(account);
    }

    @DeleteMapping("/enterprise/{enterpriseId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("enterpriseId")Integer enterpriseId){
        //System.out.println("根据ID删除企业");

        return enterpriseService.deleteByPrimaryKey(enterpriseId);
    }

    @PutMapping("/enterprise")
    public ApiResult update(@RequestBody Enterprise enterprise){
        //System.out.println("修改企业");
        return enterpriseService.update(enterprise);
    }

    @PostMapping("/enterprise")
    public ApiResult insert(@RequestBody Enterprise enterprise){
        //System.out.println("添加企业");
        return enterpriseService.insert(enterprise);
    }
}
