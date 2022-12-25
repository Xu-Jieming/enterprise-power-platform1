package com.epp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.mapper.BranchPowerMapper;
import com.epp.mapper.HourlyPowerMapper;
import com.epp.pojo.ApiResult;
import com.epp.pojo.BranchPower;
import com.epp.pojo.BranchPower;
import com.epp.pojo.BranchPower;
import com.epp.service.BranchPowerService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/13:49
 * @Description:
 */
public class BranchPowerServiceImpl implements BranchPowerService {

    @Autowired
    private BranchPowerMapper mapper;

    @Autowired
    private HourlyPowerMapper hourlyPowerMapper;

    Calendar ca = Calendar.getInstance();

    @Override
    public ApiResult selectAll() {
        List<BranchPower> powerList = mapper.selectAll();
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "所有支路用能查询成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "所有支路用能查询失败", null);

    }

    @Override
    public ApiResult selectAll(Page<BranchPower> page) {
        IPage<BranchPower> powerList = mapper.selectAll(page);
        if(powerList != null){
            return ApiResultHandler.buildApiResult(200, "分页查询所有支路用能成功", powerList);
        }
        return ApiResultHandler.buildApiResult(400, "分页查询所有支路用能失败", null);

    }

    @Override
    public ApiResult selectByPrimaryKey(Integer branchPowerId) {
        BranchPower power = mapper.selectByPrimaryKey(branchPowerId);
        if(power != null){
            return ApiResultHandler.buildApiResult(200, "支路用能查询成功", power);
        }
        return ApiResultHandler.buildApiResult(400, "支路用能查询失败", null);

    }

    @Override
    public ApiResult deleteByPrimaryKey(Integer branchPowerId) {
        int deleteId = mapper.deleteByPrimaryKey(branchPowerId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "删除失败", null);

    }

    @Override
    public ApiResult update(BranchPower branchPower) {
        int day =ca.get(Calendar.DAY_OF_YEAR);//一年中的第几天

        int month =ca.get(Calendar.MONTH);//第几个月

        int year =ca.get(Calendar.YEAR);//年份数值


        int updateBranchPower = mapper.updateByPrimaryKey(branchPower);
        if(updateBranchPower != 0){
            return ApiResultHandler.buildApiResult(200, "修改成功", updateBranchPower);
        }
        return ApiResultHandler.buildApiResult(400, "修改失败", null);

    }

    @Override
    public ApiResult insert(BranchPower branchPower) {
        int insertBranchPower = mapper.insert(branchPower);
        if(insertBranchPower != 0){
            return ApiResultHandler.buildApiResult(200, "添加成功", insertBranchPower);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", null);

    }
}
