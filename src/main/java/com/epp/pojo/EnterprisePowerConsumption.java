package com.epp.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:13
 * @Description:电费分项用能情况
 */
public class EnterprisePowerConsumption {

    private Integer enterpriseId;

    private String enterpriseName;

    private double firstRatePower;//第一阶梯用能情况

    private double secondRatePower;//第二阶梯用能情况

    private double thirdRatePower;//第三阶梯用能情况

    private double firstRatePayment;//第一阶梯需缴纳费用

    private double secondRatePayment;//第二阶梯需缴纳费用

    private double thirdRatePayment;//第三阶梯需缴纳费用

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public double getFirstRatePower() {
        return firstRatePower;
    }

    public void setFirstRatePower(double firstRatePower) {
        this.firstRatePower = firstRatePower;
    }

    public double getSecondRatePower() {
        return secondRatePower;
    }

    public void setSecondRatePower(double secondRatePower) {
        this.secondRatePower = secondRatePower;
    }

    public double getThirdRatePower() {
        return thirdRatePower;
    }

    public void setThirdRatePower(double thirdRatePower) {
        this.thirdRatePower = thirdRatePower;
    }

    public double getFirstRatePayment() {
        return firstRatePayment;
    }

    public void setFirstRatePayment(double firstRatePayment) {
        this.firstRatePayment = firstRatePayment;
    }

    public double getSecondRatePayment() {
        return secondRatePayment;
    }

    public void setSecondRatePayment(double secondRatePayment) {
        this.secondRatePayment = secondRatePayment;
    }

    public double getThirdRatePayment() {
        return thirdRatePayment;
    }

    public void setThirdRatePayment(double thirdRatePayment) {
        this.thirdRatePayment = thirdRatePayment;
    }
}
