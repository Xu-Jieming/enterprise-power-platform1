package com.epp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.sun.tools.javac.util.DefinedBy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/9:47
 * @Description:
 */
public interface AdminService {

    public ApiResult selectAll();

    public ApiResult selectByAccount(Integer account);

    public ApiResult deleteByAccount(Integer account);

    public ApiResult update(Admin admin);

    public ApiResult insert(Admin admin);


}
