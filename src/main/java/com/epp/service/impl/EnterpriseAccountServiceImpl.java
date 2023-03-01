package com.epp.service.impl;

import com.epp.mapper.EnterpriseAccountMapper;
import com.epp.mapper.EnterpriseAccountMapper;
import com.epp.mapper.EnterprisePaymentMapper;
import com.epp.pojo.EnterpriseAccount;
import com.epp.pojo.ApiResult;
import com.epp.pojo.EnterprisePayment;
import com.epp.service.EnterpriseAccountService;
import com.epp.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/25/9:51
 * @Description:
 */
@Service
public class EnterpriseAccountServiceImpl implements EnterpriseAccountService {

    @Autowired
    private EnterpriseAccountMapper accountMapper;

    @Autowired
    private EnterprisePaymentMapper paymentMapper;

    @Override
    public ApiResult selectAll() {
        List<EnterpriseAccount> enterpriseAccounts= accountMapper.selectAll();
        if(enterpriseAccounts != null){
            return ApiResultHandler.buildApiResult(200, "所有存款查询成功", enterpriseAccounts);
        }
        return ApiResultHandler.buildApiResult(400, "查询失败", null);
    }

    @Override
    public ApiResult selectByEnterpriseId(Integer enterpriseId) {
        EnterpriseAccount enterpriseAccount = accountMapper.selectByEnterpriseId(enterpriseId);
        if (enterpriseAccount != null) {
            return ApiResultHandler.buildApiResult(200, "存款查询成功", enterpriseAccount);
        }
        return ApiResultHandler.buildApiResult(400, "查询失败", null);

    }

    @Override
    public ApiResult deleteByAccount(Integer enterpriseId) {
        int deleteId = accountMapper.deleteByPrimaryKey(enterpriseId);
        if(deleteId != 0){
            return ApiResultHandler.buildApiResult(200, "存款删除成功", deleteId);
        }
        return ApiResultHandler.buildApiResult(400, "存款删除失败", null);
    }

    @Override
    public ApiResult update(EnterpriseAccount enterpriseAccount) {

        int enterpriseId = enterpriseAccount.getEnterpriseId();
        List<EnterprisePayment> payments = paymentMapper.selectByEnterpriseId(enterpriseId);
        double account = enterpriseAccount.getCurrentAccount();//这个用来保存扣完后的钱，初始化就是所有的钱
        for(int i = payments.size() -1; i >= 0 ; i--){

            if(payments.get(i).getStatus() == 0 ){//没有交完钱，而且还有钱需要扣
                double lessMore = payments.get(i).getSumPayment()-payments.get(i).getCounted();//本月还有这么多钱需要扣

                //然后将已有的钱减去应该扣的钱
                if(lessMore <= account){//如果账户存款大于等于应该要扣的钱
                    payments.get(i).setCounted(payments.get(i).getSumPayment());//将这些纳入进已经算过的总数
                    account = account - lessMore;//那么就直接把这个月的交完
                    payments.get(i).setStatus(1);//交完钱了，就要把它设为1了
                }else{//如果要扣的钱大于现期存款，那么就将账户的钱放进已经算过的总数
                    payments.get(i).setCounted(payments.get(i).getCounted()+ account);
                    account = 0;
                }
                paymentMapper.updateByPrimaryKey(payments.get(i));//将更新后的payment放进数据库内
            }
             //交过钱的就不用理了
        }
                enterpriseAccount.setCurrentAccount(account);//然后将剩余的钱放进去账户里面就好了
        int updateEnterpriseAccount = accountMapper.updateByPrimaryKey(enterpriseAccount);
        if(updateEnterpriseAccount != 0){
            return ApiResultHandler.buildApiResult(200, "存款修改成功", updateEnterpriseAccount);
        }
        return ApiResultHandler.buildApiResult(400, "存款修改失败", null);
    }

    @Override
    public ApiResult insert(Integer enterpriseId) {
        EnterpriseAccount enterpriseAccount = new EnterpriseAccount();
        enterpriseAccount.setCurrentAccount(0.0);
        enterpriseAccount.setEnterpriseId(enterpriseId);
        int addEnterpriseAccount = accountMapper.insert(enterpriseAccount);
        if(addEnterpriseAccount != 0){
            return ApiResultHandler.buildApiResult(200, "存款增加成功", addEnterpriseAccount);
        }
        return ApiResultHandler.buildApiResult(400, "存款增加失败", null);
    }
}
