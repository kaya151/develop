package com.tuomi.develop.entity;

public class Im {

	private Long id;
	private String openId;
	private String nickName;
	private String token;
	private String headImg;
	private String types;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "Im [id=" + id + ", openId=" + openId + ", nickName=" + nickName + ", token=" + token + ", headImg="
				+ headImg + ", types=" + types + "]";
	}
	
}
