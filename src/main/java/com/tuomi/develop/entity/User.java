package com.tuomi.develop.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String openId;

    private String nickName;

    private String token;

    private Integer status;

    private String file;

    private String tel;

    private Integer isTel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getIsTel() {
        return isTel;
    }

    public void setIsTel(Integer isTel) {
        this.isTel = isTel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", file='" + file + '\'' +
                ", tel='" + tel + '\'' +
                ", isTel=" + isTel +
                '}';
    }
}