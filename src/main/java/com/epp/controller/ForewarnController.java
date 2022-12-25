package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Forewarn;
import com.epp.service.ForewarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class ForewarnController {
    @Autowired
    private ForewarnService forewarnService;

    @GetMapping("/forewarn")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return forewarnService.selectAll();
    }

    @GetMapping("/forewarn/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部预警");
        Page<Forewarn> forewarnPage = new Page<>(page,size);
        return forewarnService.selectAll(forewarnPage);
    }


    @GetMapping("/forewarn/{forewarnId}")
    public ApiResult selectByPrimaryKey(@PathVariable("forewarnId")Integer forewarnId){
        //System.out.println("根据ID查找预警");
        return forewarnService.selectByPrimaryKey(forewarnId);
    }

    @DeleteMapping("/forewarn/{forewarnId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("forewarnId")Integer forewarnId){
        //System.out.println("根据ID删除预警");

        return forewarnService.deleteByPrimaryKey(forewarnId);
    }

    @PutMapping("/forewarn")
    public ApiResult update(@RequestBody Forewarn forewarn){
        //System.out.println("修改预警");
        return forewarnService.update(forewarn);
    }

    @PostMapping("/forewarn")
    public ApiResult insert(@RequestBody Forewarn forewarn){
        //System.out.println("添加预警");
        return forewarnService.insert(forewarn);
    }
}
