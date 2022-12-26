package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.ForewarnMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.Forewarn;
import com.epp.pojo.Forewarn;
import com.epp.service.ForewarnService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForewarnServiceImpl implements ForewarnService {
    @Autowired
    private ForewarnMapper mapper;
    
    @Override
    public ApiResult selectAll() {
        List<Forewarn> forewarnList = mapper.selectAll();
        if(forewarnList != null){
            return ApiResultHandler.buildApiResult(200, "所有预警查询成功", forewarnList);
        }
        return ApiResultHandler.buildApiResult(400, "所有预警查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<Forewarn> page) {
        IPage<Forewarn> forewarnList = mapper.selectAll(page);
        if(forewarnList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有预警成功", forewarnList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有预警失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer forewarnId) {
        Forewarn forewarn = mapper.selectByPrimaryKey(forewarnId);
        if(forewarn != null){
            return ApiResultHandler.buildApiResult(200, "预警查询成功", forewarn);
        }
        return ApiResultHandler.buildApiResult(400, "预警查询失败", null);

    }


    @Override
    public ApiResult deleteByPrimaryKey(Integer forewarnId) {
        int deleteId = mapper.deleteByPrimaryKey(forewarnId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(Forewarn forewarn) {
        int updateForewarn = mapper.updateByPrimaryKey(forewarn);
        if(updateForewarn != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateForewarn);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(Forewarn forewarn) {
        int insertForewarn = mapper.insert(forewarn);
        if(insertForewarn != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertForewarn);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
