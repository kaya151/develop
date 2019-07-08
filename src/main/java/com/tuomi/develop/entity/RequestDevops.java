package com.tuomi.develop.entity;

import java.io.Serializable;

/**
 * @version: V1.0

 * @description: 请求维护
 * @date 2019/6/3 17:24
 */
public class RequestDevops implements Serializable {
    private Integer id;

    private Integer activityStart;

    private Integer activityEnd;

    private Float devopsCost;

    private Integer fatherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Integer activityStart) {
        this.activityStart = activityStart;
    }

    public Integer getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Integer activityEnd) {
        this.activityEnd = activityEnd;
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

    @Override
    public String toString() {
        return "RequestDevops{" +
                "id=" + id +
                ", activityStart=" + activityStart +
                ", activityEnd=" + activityEnd +
                ", devopsCost=" + devopsCost +
                ", fatherId=" + fatherId +
                '}';
    }
}