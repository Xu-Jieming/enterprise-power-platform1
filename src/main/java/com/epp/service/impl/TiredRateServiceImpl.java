package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.TiredRateMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.TiredRate;
import com.epp.pojo.TiredRate;
import com.epp.service.TiredRateService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:37
 * @Description:
 */

@Service
public class TiredRateServiceImpl implements TiredRateService{


    @Autowired
    private TiredRateMapper mapper;

    @Override
    public ApiResult selectAll() {
        List<TiredRate> tiredRateList = mapper.selectAll();
        if(tiredRateList != null){
            return ApiResultHandler.buildApiResult(200, "所有阶梯费率查询成功", tiredRateList);
        }
        return ApiResultHandler.buildApiResult(400, "所有阶梯费率查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<TiredRate> page) {
        IPage<TiredRate> tiredRateList = mapper.selectAll(page);
        if(tiredRateList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有阶梯费率成功", tiredRateList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有阶梯费率失败", null);

    }

    @Override
    public TiredRate selectByDate(Integer year, Integer month) {
        TiredRate tiredRate = mapper.selectByDate(year,month);
        return tiredRate;
    }

    @Override
    public ApiResult selectByPrimaryKey(Integer tiredRateId) {
        TiredRate tiredRate = mapper.selectByPrimaryKey(tiredRateId);
        if(tiredRate != null){
            return ApiResultHandler.buildApiResult(200, "阶梯费率查询成功", tiredRate);
        }
        return ApiResultHandler.buildApiResult(400, "阶梯费率查询失败", null);

    }


    @Override
    public ApiResult deleteByPrimaryKey(Integer tiredRateId) {
        int deleteId = mapper.deleteByPrimaryKey(tiredRateId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(TiredRate tiredRate) {
        int updateTiredRate = mapper.updateByPrimaryKey(tiredRate);
        if(updateTiredRate != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateTiredRate);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(TiredRate tiredRate) {
        int insertTiredRate = mapper.insert(tiredRate);
        if(insertTiredRate != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertTiredRate);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }


}