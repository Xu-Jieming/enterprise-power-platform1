package com.epp.pojo;

import java.util.Date;

import lombok.Data;
@Data
public class Forewarn {
    private Integer forewarnId;

    private Integer enterpriseId;

    private String warningTime;

    private Double warningPower;

    private Integer warningFrequency;

    private Date created;

    public Integer getForewarnId() {
        return forewarnId;
    }

    public void setForewarnId(Integer forewarnId) {
        this.forewarnId = forewarnId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(String warningTime) {
        this.warningTime = warningTime == null ? null : warningTime.trim();
    }

    public Double getWarningPower() {
        return warningPower;
    }

    public void setWarningPower(Double warningPower) {
        this.warningPower = warningPower;
    }

    public Integer getWarningFrequency() {
        return warningFrequency;
    }

    public void setWarningFrequency(Integer warningFrequency) {
        this.warningFrequency = warningFrequency;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}