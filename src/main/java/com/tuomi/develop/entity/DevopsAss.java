package com.tuomi.develop.entity;

import java.io.Serializable;

/**
 * @version: V1.0

 * @description: 运维评估
 * @date 2019/6/3 17:26
 */
public class DevopsAss implements Serializable {
    private Integer id;

    private String product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }
}