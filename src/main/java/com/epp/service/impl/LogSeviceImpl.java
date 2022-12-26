package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.LogMapper;
import com.epp.mapper.LogMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Log;
import com.epp.pojo.Log;
import com.epp.service.LogService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSeviceImpl implements LogService {
    
    @Autowired
    private LogMapper mapper;

    @Override
    public ApiResult selectAll() {
        List<Log> logList = mapper.selectAll();
        if(logList != null){
            return ApiResultHandler.buildApiResult(200, "所有日志查询成功", logList);
        }
        return ApiResultHandler.buildApiResult(400, "所有日志查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<Log> page) {
        IPage<Log> logList = mapper.selectAll(page);
        if(logList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有日志成功", logList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有日志失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer logId) {
        Log log = mapper.selectByPrimaryKey(logId);
        if(log != null){
            return ApiResultHandler.buildApiResult(200, "日志查询成功", log);
        }
        return ApiResultHandler.buildApiResult(400, "日志查询失败", null);

    }


    @Override
    public ApiResult deleteByPrimaryKey(Integer logId) {
        int deleteId = mapper.deleteByPrimaryKey(logId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(Log log) {
        int updateLog = mapper.updateByPrimaryKey(log);
        if(updateLog != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateLog);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Log log) {
        int insertLog = mapper.insert(log);
        if(insertLog != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertLog);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
