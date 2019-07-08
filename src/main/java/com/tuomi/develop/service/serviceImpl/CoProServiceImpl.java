package com.tuomi.develop.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuomi.develop.dao.CoProMapper;
import com.tuomi.develop.entity.CoPro;
import com.tuomi.develop.service.CoProService;

@Service
public class CoProServiceImpl implements CoProService{

	@Autowired
	private CoProMapper coProMapper;
	@Override
	public int save(CoPro coPro) {
		return coProMapper.save(coPro);
	}

	@Override
	public int edit(CoPro coPro) {
		return coProMapper.edit(coPro);
	}

	@Override
	public int del(Long id) {
		return coProMapper.del(id);
	}

	@Override
	public CoPro getAllById(Long id) {
		return coProMapper.getAllById(id);
	}

	@Override
	public List<CoPro> getAll() {
		return coProMapper.getAll();
	}

}
