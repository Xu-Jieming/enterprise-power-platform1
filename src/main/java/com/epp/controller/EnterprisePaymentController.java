package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePayment;
import com.epp.service.EnterprisePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class EnterprisePaymentController {

    @Autowired
    private EnterprisePaymentService enterprisePaymentService;

    @GetMapping("/enterprisePayment")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return enterprisePaymentService.selectAll();
    }

    @GetMapping("/enterprisePayment/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部企业费用");
        Page<EnterprisePayment> enterprisePaymentPage = new Page<>(page,size);
        return enterprisePaymentService.selectAll(enterprisePaymentPage);
    }


    @GetMapping("/enterprisePayment/{enterprisePaymentId}")
    public ApiResult selectByPrimaryKey(@PathVariable("enterprisePaymentId")Integer enterprisePaymentId){
        //System.out.println("根据ID查找企业费用");
        return enterprisePaymentService.selectByPrimaryKey(enterprisePaymentId);
    }

    @DeleteMapping("/enterprisePayment/{enterprisePaymentId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("enterprisePaymentId")Integer enterprisePaymentId){
        //System.out.println("根据ID删除企业费用");

        return enterprisePaymentService.deleteByPrimaryKey(enterprisePaymentId);
    }

    @PutMapping("/enterprisePayment")
    public ApiResult update(@RequestBody Integer enterpriseId){
        //System.out.println("修改企业费用");
        return enterprisePaymentService.update(enterpriseId);
    }

    @PostMapping("/enterprisePayment")
    public ApiResult insert(@RequestBody EnterprisePayment enterprisePayment){
        //System.out.println("添加企业费用");
        return enterprisePaymentService.insert(enterprisePayment.getEnterpriseId());
    }
}
