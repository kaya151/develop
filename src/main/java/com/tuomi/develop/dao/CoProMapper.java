package com.tuomi.develop.dao;

import java.util.List;

import com.tuomi.develop.entity.CoPro;

public interface CoProMapper {

	int save(CoPro coPro);
	int edit(CoPro coPro);
	int del(Long id);
	CoPro getAllById(Long id );
	List<CoPro> getAll();
	
}
