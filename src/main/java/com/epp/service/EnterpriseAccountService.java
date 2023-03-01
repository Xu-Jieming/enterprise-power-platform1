package com.epp.service;

import com.epp.pojo.Admin;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterpriseAccount;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/9:47
 * @Description:
 */
public interface EnterpriseAccountService {

    public ApiResult selectAll();

    public ApiResult selectByEnterpriseId(Integer enterpriseId);

    public ApiResult deleteByAccount(Integer enterpriseId);

    public ApiResult update(EnterpriseAccount admin);

    public ApiResult insert(Integer enterpriseId);


}
