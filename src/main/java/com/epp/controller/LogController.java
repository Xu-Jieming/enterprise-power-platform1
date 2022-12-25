package com.epp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Log;
import com.epp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class LogController {
    
    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public ApiResult selectAll(){
        //System.out.println("查询全部");
        return logService.selectAll();
    }

    @GetMapping("/log/{page}/{size}")
    public ApiResult selectAll(@PathVariable("page") Integer page,
                               @PathVariable("size") Integer size){
        //System.out.println("分页查询全部日志");
        Page<Log> logPage = new Page<>(page,size);
        return logService.selectAll(logPage);
    }


    @GetMapping("/log/{logId}")
    public ApiResult selectByPrimaryKey(@PathVariable("logId")Integer logId){
        //System.out.println("根据ID查找日志");
        return logService.selectByPrimaryKey(logId);
    }

    @DeleteMapping("/log/{logId}")
    public ApiResult deleteByPrimaryKey(@PathVariable("logId")Integer logId){
        //System.out.println("根据ID删除日志");

        return logService.deleteByPrimaryKey(logId);
    }

    @PutMapping("/log")
    public ApiResult update(@RequestBody Log log){
        //System.out.println("修改日志");
        return logService.update(log);
    }

    @PostMapping("/log")
    public ApiResult insert(@RequestBody Log log){
        //System.out.println("添加日志");
        return logService.insert(log);
    }
}
