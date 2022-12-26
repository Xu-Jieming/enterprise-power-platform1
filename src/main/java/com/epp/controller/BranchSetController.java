package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchSet;
import com.epp.service.BranchSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class BranchSetController {
    @Autowired
    private BranchSetService branchSetService;

    @GetMapping("/branchSet")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return branchSetService.selectAll();
    }

    @GetMapping("/branchSet/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部企业用能");
        Page<BranchSet> branchSetPage = new Page<>(page,size);
        return branchSetService.selectAll(branchSetPage);
    }


    @GetMapping("/branchSet/{enterpriseId}")
    public ApiResult selectByPrimaryKey(@PathVariable("branchSetId")Integer enterpriseId){
        //System.out.println("根据企业ID查找企业用能");
        return branchSetService.selectByEnterpriseId(enterpriseId);
    }

    @DeleteMapping("/branchSet/{branchSetId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("branchSetId")Integer branchSetId){
        //System.out.println("根据ID删除企业用能");

        return branchSetService.deleteByPrimaryKey(branchSetId);
    }

    @PutMapping("/branchSet")
    public ApiResult update(@RequestBody BranchSet branchSet){
        //System.out.println("修改企业用能");
        return branchSetService.update(branchSet);
    }

    @PostMapping("/branchSet")
    public ApiResult insert(@RequestBody BranchSet branchSet){
        //System.out.println("添加企业用能");
        return branchSetService.insert(branchSet.getEnterpriseId());
    }
}
