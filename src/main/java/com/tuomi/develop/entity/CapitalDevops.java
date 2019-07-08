package com.tuomi.develop.entity;

import java.io.Serializable;

/**
 * @version: V1.0

 * @description: 资金维护
 * @date 2019/6/3 17:24
 */
public class CapitalDevops implements Serializable {
    private Integer id;

    private Integer turnoverStart;

    private Integer turnoverEnd;

    private Float devopsCost;

    private Integer fatherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurnoverStart() {
        return turnoverStart;
    }

    public void setTurnoverStart(Integer turnoverStart) {
        this.turnoverStart = turnoverStart;
    }

    public Integer getTurnoverEnd() {
        return turnoverEnd;
    }

    public void setTurnoverEnd(Integer turnoverEnd) {
        this.turnoverEnd = turnoverEnd;
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