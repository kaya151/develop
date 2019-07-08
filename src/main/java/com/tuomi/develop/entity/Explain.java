package com.tuomi.develop.entity;

import java.io.Serializable;

public class Explain implements Serializable {
    private Integer id;

    private String name;

    private String describe;

    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

	@Override
	public String toString() {
		return "Explain [id=" + id + ", name=" + name + ", describe=" + describe + ", category=" + category + "]";
	}
    
}