package com.tuomi.develop.entity;

import java.io.Serializable;

public class ManualAss implements Serializable {
    private Integer id;

    private String product;

    private String describe;

    private String file;

    private Integer isFile;

    private String reply;

    private Integer status;

    private Integer userId;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getIsFile() {
        return isFile;
    }

    public void setIsFile(Integer isFile) {
        this.isFile = isFile;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ManualAss{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", describe='" + describe + '\'' +
                ", file='" + file + '\'' +
                ", isFile=" + isFile +
                ", reply='" + reply + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}