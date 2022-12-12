package com.epp.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu jieming
 * @Date: 2022/12/11/20:03
 * @Description:分项费率
 */
public class TiredRates {

    private double firstTieredRates;//第一阶梯费率

    private Integer firstRateInterval;//第一阶梯电价区间内容

    private String firstRateContent;//第一阶梯电价区间内容

    private double secondTieredRates;//第二阶梯费率

    private Integer secondRateInterval;//第二阶梯电价区间

    private String secondRateContent;//第二阶梯电价区间内容

    private double thirdTieredRates;//第三阶梯费率

    private Integer thirdRateInterval;//第三阶梯电价区间

    private String thirdRateContent;//第三阶梯电价区间内容

    public double getFirstTieredRates() {
        return firstTieredRates;
    }

    public void setFirstTieredRates(double firstTieredRates) {
        this.firstTieredRates = firstTieredRates;
    }

    public Integer getFirstRateInterval() {
        return firstRateInterval;
    }

    public void setFirstRateInterval(Integer firstRateInterval) {
        this.firstRateInterval = firstRateInterval;
    }

    public String getFirstRateContent() {
        return firstRateContent;
    }

    public void setFirstRateContent(String firstRateContent) {
        this.firstRateContent = firstRateContent;
    }

    public double getSecondTieredRates() {
        return secondTieredRates;
    }

    public void setSecondTieredRates(double secondTieredRates) {
        this.secondTieredRates = secondTieredRates;
    }

    public Integer getSecondRateInterval() {
        return secondRateInterval;
    }

    public void setSecondRateInterval(Integer secondRateInterval) {
        this.secondRateInterval = secondRateInterval;
    }

    public String getSecondRateContent() {
        return secondRateContent;
    }

    public void setSecondRateContent(String secondRateContent) {
        this.secondRateContent = secondRateContent;
    }

    public double getThirdTieredRates() {
        return thirdTieredRates;
    }

    public void setThirdTieredRates(double thirdTieredRates) {
        this.thirdTieredRates = thirdTieredRates;
    }

    public Integer getThirdRateInterval() {
        return thirdRateInterval;
    }

    public void setThirdRateInterval(Integer thirdRateInterval) {
        this.thirdRateInterval = thirdRateInterval;
    }

    public String getThirdRateContent() {
        return thirdRateContent;
    }

    public void setThirdRateContent(String thirdRateContent) {
        this.thirdRateContent = thirdRateContent;
    }
}
