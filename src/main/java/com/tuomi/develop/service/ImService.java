package com.tuomi.develop.service;

import com.tuomi.develop.entity.Im;

public interface ImService {

	Im findImByOpenId(String id);
	int save(Im im);
}
