package com.tuomi.develop.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


public interface BaseService<T> {

	int save(T t);
	int edit(T t);
	int del(Serializable id);
	T findById(Serializable id);
	List<T> findAll();
}
