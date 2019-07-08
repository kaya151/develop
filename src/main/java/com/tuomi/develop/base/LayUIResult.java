package com.tuomi.develop.base;
/**
 * @description: layui响应bean
 * @author wangcong
 *
 */
public class LayUIResult {
	
	private Integer code=0;
    private Long count;
    private String msg="ok";
    private Object data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "LayUIResult [code=" + code + ", count=" + count + ", msg=" + msg + ", data=" + data + "]";
	}
	public LayUIResult(Integer code, Long count, String msg, Object data) {
		super();
		this.code = code;
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
	public LayUIResult() {
	}
	public LayUIResult(Long count, String msg, Object data) {
		super();
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
	public LayUIResult(Long count, Object data) {
		super();
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
    

}
