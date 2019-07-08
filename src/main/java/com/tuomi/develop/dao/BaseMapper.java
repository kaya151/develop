package com.tuomi.develop.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseMapper<T> {

	int save(T t);
	int edit(T t);
	int del(Serializable id);
	T findById(Serializable id);
	List<T> findAll();
	
}
