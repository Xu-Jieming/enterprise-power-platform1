package com.epp.service.impl;

import com.epp.mapper.AdminMapper;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.service.AdminService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/9:51
 * @Description:
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResult selectAll() {
        List<Admin> admins= adminMapper.selectAll();
        if(admins != null){
            return ApiResultHandler.buildApiResult(200, "所有管理员查询成功", admins);
        }
        return ApiResultHandler.buildApiResult(400, "查询失败", null);
    }

    @Override
    public ApiResult selectByAccount(Integer account) {
        Admin admin = adminMapper.selectByAccount(account);
        if (admin != null) {
            return ApiResultHandler.buildApiResult(200, "管理员查询成功", admin);
        }
        return ApiResultHandler.buildApiResult(400, "查询失败", null);

    }

    @Override
    public ApiResult deleteByAccount(Integer account) {
        int deleteId = adminMapper.deleteByAccount(account);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "管理员删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "管理员删除失败", null);
    }

    @Override
    public ApiResult update(Admin admin) {
        int updateAdmin = adminMapper.updateByPrimaryKey(admin);
        if(updateAdmin != 0){
            return ApiResultHandler.buildApiResult(200, "管理员修改成功", updateAdmin);
        }
        return ApiResultHandler.buildApiResult(400, "管理员修改失败", null);
    }

    @Override
    public ApiResult insert(Admin admin) {
        int addAdmin = adminMapper.insert(admin);
        if(addAdmin != 0){
            return ApiResultHandler.buildApiResult(200, "管理员增加成功", addAdmin);
        }
        return ApiResultHandler.buildApiResult(400, "管理员增加失败", null);
    }
}
