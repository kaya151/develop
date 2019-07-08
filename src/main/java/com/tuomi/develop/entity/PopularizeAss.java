package com.tuomi.develop.entity;

import java.io.Serializable;
import java.util.List;

public class PopularizeAss implements Serializable {
    private Integer id;

    private String product;

    private String img;

    private List<PopularizePro> list;

    public List<PopularizePro> getList() {
        return list;
    }

    public void setList(List<PopularizePro> list) {
        this.list = list;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    @Override
    public String toString() {
        return "PopularizeAss{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", img='" + img + '\'' +
                ", list=" + list +
                '}';
    }
}