package com.tuomi.develop.service.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tuomi.develop.dao.BaseMapper;
import com.tuomi.develop.service.BaseService;


@Transactional(readOnly = true)
public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	private BaseMapper<T> baseMapper;
	@Override
	@Transactional
	public int save(T t) {
		return baseMapper.save(t);
	}

	@Override
	@Transactional
	public int edit(T t) {
		return baseMapper.edit(t);
	}

	@Override
	@Transactional
	public int del(Serializable id) {
		return baseMapper.del(id);
	}

	@Override
	public T findById(Serializable id) {
		return baseMapper.findById(id);
	}

	@Override
	public List<T> findAll() {
		return baseMapper.findAll();
	}

}
