package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.TiredRate;
import com.epp.service.TiredRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/20:28
 * @Description:
 */
@Controller
@CrossOrigin
@ResponseBody
public class TiredRateController {

    @Autowired
    private TiredRateService rateService;

    @GetMapping("/tiredRate")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return rateService.selectAll();
    }

    @GetMapping("/tiredRate/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部阶梯费率");
        Page<TiredRate> tiredRatePage = new Page<>(page,size);
        return rateService.selectAll(tiredRatePage);
    }


    @GetMapping("/tiredRate/{rateId}")
    public ApiResult selectByPrimaryKey(@PathVariable("rateId")Integer rateId){
        //System.out.println("根据ID查找阶梯费率");
        return rateService.selectByPrimaryKey(rateId);
    }

    @DeleteMapping("/tiredRate/{rateId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("rateId")Integer rateId){
        //System.out.println("根据ID删除阶梯费率");

        return rateService.deleteByPrimaryKey(rateId);
    }

    @PutMapping("/tiredRate")
    public ApiResult update(@RequestBody TiredRate tiredRate){
        //System.out.println("修改阶梯费率");
        return rateService.update(tiredRate);
    }

    @PostMapping("/tiredRate")
    public ApiResult insert(@RequestBody TiredRate tiredRate){
        //System.out.println("添加阶梯费率");
        return rateService.insert(tiredRate);
    }
}
