package com.tuomi.develop.entity;

import java.io.Serializable;

/**
 * @version: V1.0

 * @description: 自助评估
 * @date 2019/6/3 17:25
 */
public class SelfAss implements Serializable {
    private Integer id;

    private Integer developmentTime;

    private Integer backNumber;

    private Integer frontNumber;

    private Float completionRate;

    private Float develomentCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevelopmentTime() {
        return developmentTime;
    }

    public void setDevelopmentTime(Integer developmentTime) {
        this.developmentTime = developmentTime;
    }

    public Integer getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(Integer backNumber) {
        this.backNumber = backNumber;
    }

    public Integer getFrontNumber() {
        return frontNumber;
    }

    public void setFrontNumber(Integer frontNumber) {
        this.frontNumber = frontNumber;
    }

    public Float getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(Float completionRate) {
        this.completionRate = completionRate;
    }

    public Float getDevelomentCost() {
        return develomentCost;
    }

    public void setDevelomentCost(Float develomentCost) {
        this.develomentCost = develomentCost;
    }

    @Override
    public String toString() {
        return "SelfAss{" +
                "id=" + id +
                ", developmentTime=" + developmentTime +
                ", backNumber=" + backNumber +
                ", frontNumber=" + frontNumber +
                ", completionRate=" + completionRate +
                ", develomentCost=" + develomentCost +
                '}';
    }
}