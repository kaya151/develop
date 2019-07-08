package com.tuomi.develop.entity;

import java.io.Serializable;

/**
 * @version: V1.0

 * @description: 常规维护
 * @date 2019/6/3 17:24
 */
public class RoutineDevops implements Serializable {
    private Integer id;

    private Float developmentMoney;

    private Float devopsCost;

    private Integer fatherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDevelopmentMoney() {
        return developmentMoney;
    }

    public void setDevelopmentMoney(Float developmentMoney) {
        this.developmentMoney = developmentMoney;
    }

    public Float getDevopsCost() {
        return devopsCost;
    }

    public void setDevopsCost(Float devopsCost) {
        this.devopsCost = devopsCost;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
}