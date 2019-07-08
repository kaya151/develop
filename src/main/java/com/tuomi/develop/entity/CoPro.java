package com.tuomi.develop.entity;

public class CoPro {

	private Long id;
	private String name;
	private String link;
	private Long fid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "CoPro [id=" + id + ", name=" + name + ", link=" + link + ", fid=" + fid + "]";
	}
	
}
