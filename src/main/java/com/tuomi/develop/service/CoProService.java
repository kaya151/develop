package com.tuomi.develop.service;

import java.util.List;

import com.tuomi.develop.entity.CoPro;

public interface CoProService {

	int save(CoPro coPro);
	int edit(CoPro coPro);
	int del(Long id);
	CoPro getAllById(Long id );
	List<CoPro> getAll();
}
