package com.tuomi.develop.entity;

import java.io.Serializable;

public class PopularizePro implements Serializable {
    private Integer id;

    private String product;

    private Integer price;

    private Integer fatherId;

    private String img;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    @Override
    public String toString() {
        return "PopularizePro{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", fatherId=" + fatherId +
                ", img='" + img + '\'' +
                '}';
    }
}