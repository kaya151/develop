package com.tuomi.develop.entity;

public class UserInfo {
	private Long  id;
	private String tel;
	private Im imWeChatId;
	private Im imQqId;
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Im getImWeChatId() {
		return imWeChatId;
	}
	public void setImWeChatId(Im imWeChatId) {
		this.imWeChatId = imWeChatId;
	}
	public Im getImQqId() {
		return imQqId;
	}
	public void setImQqId(Im imQqId) {
		this.imQqId = imQqId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", tel=" + tel + ", imWeChatId=" + imWeChatId + ", imQqId=" + imQqId + ", state="
				+ state + "]";
	}
	
	
	
	

}
