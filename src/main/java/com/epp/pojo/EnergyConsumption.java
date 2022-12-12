package com.epp.pojo;

/*能耗情况*/
public class EnergyConsumption {

    private Integer powerId;

    private Integer enterpriseId;

    private double lpg;//液化石油气

    private double naturalGas;//天然气

    private double thermal;//热力

    private double electricity;//电力

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public double getLpg() {
        return lpg;
    }

    public void setLpg(double lpg) {
        this.lpg = lpg;
    }

    public double getNaturalGas() {
        return naturalGas;
    }

    public void setNaturalGas(double naturalGas) {
        this.naturalGas = naturalGas;
    }

    public double getThermal() {
        return thermal;
    }

    public void setThermal(double thermal) {
        this.thermal = thermal;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }
}
