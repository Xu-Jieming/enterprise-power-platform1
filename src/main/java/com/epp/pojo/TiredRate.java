package com.epp.pojo;

import lombok.Data;
@Data
public class TiredRate {
    private Integer rateId;

    private Integer firstRateInterval;

    private Integer secondRateInterval;

    private Integer thirdRateInterval;

    private Double firstTiredRate;

    private Double secondTiredRate;

    private Double thirdTiredRate;

    private Integer year;

    private Integer month;

    private String comment;

    private String firstRateContent;

    private String secondRateContent;

    private String thirdRateContent;

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getFirstRateInterval() {
        return firstRateInterval;
    }

    public void setFirstRateInterval(Integer firstRateInterval) {
        this.firstRateInterval = firstRateInterval;
    }

    public Integer getSecondRateInterval() {
        return secondRateInterval;
    }

    public void setSecondRateInterval(Integer secondRateInterval) {
        this.secondRateInterval = secondRateInterval;
    }

    public Integer getThirdRateInterval() {
        return thirdRateInterval;
    }

    public void setThirdRateInterval(Integer thirdRateInterval) {
        this.thirdRateInterval = thirdRateInterval;
    }

    public Double getFirstTiredRate() {
        return firstTiredRate;
    }

    public void setFirstTiredRate(Double firstTiredRate) {
        this.firstTiredRate = firstTiredRate;
    }

    public Double getSecondTiredRate() {
        return secondTiredRate;
    }

    public void setSecondTiredRate(Double secondTiredRate) {
        this.secondTiredRate = secondTiredRate;
    }

    public Double getThirdTiredRate() {
        return thirdTiredRate;
    }

    public void setThirdTiredRate(Double thirdTiredRate) {
        this.thirdTiredRate = thirdTiredRate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getFirstRateContent() {
        return firstRateContent;
    }

    public void setFirstRateContent(String firstRateContent) {
        this.firstRateContent = firstRateContent == null ? null : firstRateContent.trim();
    }

    public String getSecondRateContent() {
        return secondRateContent;
    }

    public void setSecondRateContent(String secondRateContent) {
        this.secondRateContent = secondRateContent == null ? null : secondRateContent.trim();
    }

    public String getThirdRateContent() {
        return thirdRateContent;
    }

    public void setThirdRateContent(String thirdRateContent) {
        this.thirdRateContent = thirdRateContent == null ? null : thirdRateContent.trim();
    }
}