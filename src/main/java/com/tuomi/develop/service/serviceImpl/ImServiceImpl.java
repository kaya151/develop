package com.tuomi.develop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuomi.develop.dao.ImMapper;
import com.tuomi.develop.entity.Im;
import com.tuomi.develop.service.ImService;

@Service
public class ImServiceImpl implements ImService{

	@Autowired
	private ImMapper imMapper;
	@Override
	public Im findImByOpenId(String id) {
		return imMapper.findImByOpenId(id);
	}
	@Override
	public int save(Im im) {
		return imMapper.save(im);
	}

}
