package com.tuomi.develop.dao;

import org.apache.ibatis.annotations.Param;

import com.tuomi.develop.entity.Im;

public interface ImMapper {
	Im findImByOpenId(@Param("openId")String id);
	int save(Im im);
}
