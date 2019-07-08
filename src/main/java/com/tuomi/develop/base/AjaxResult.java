package com.tuomi.develop.base;

public class AjaxResult {
	
	private Integer code;
	private String success;
	private String msg;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public AjaxResult(Integer code, String success, String msg) {
		super();
		this.code = code;
		this.success = success;
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "AjaxResult [code=" + code + ", success=" + success + ", msg=" + msg + "]";
	}
	public AjaxResult() {
		super();
	}
	
	
}
