package com.tuomi.develop.base;

import java.io.Serializable;


/**
 * 结果集基类
 * 
 *
 * 
 */
public class BaseResult implements Serializable {
	private static final long serialVersionUID = -6711131180313904332L;

	private Integer code; // 状态码
	private String msg; // 返回消息
	private Object data; // 结果对象

	public BaseResult() {

	}

	public BaseResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BaseResult(Integer code, String msg, Object result) {
		this.code = code;
		this.msg = msg;
		this.data = result;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
