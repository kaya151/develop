package com.tuomi.develop.entity;

import java.io.Serializable;

public class DevelopAss implements Serializable {
    private Integer id;

    private String product;

    private String file;

    private Integer type;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DevelopAss{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", file='" + file + '\'' +
                ", type=" + type +
                '}';
    }
}