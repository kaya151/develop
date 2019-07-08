package com.tuomi.develop.service;

import org.apache.ibatis.annotations.Param;

import com.tuomi.develop.entity.UserInfo;

public interface UserInfoService {

	int save(UserInfo userInfo);
	UserInfo getUserById(Long id);
	UserInfo findUserByWeChatId(Long wechatId);
	UserInfo findUserByQQId(@Param("QQId")Long QQId);
	UserInfo findUserById(Long id);
	int edit(UserInfo userinfo);
}
