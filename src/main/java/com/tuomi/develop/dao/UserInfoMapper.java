package com.tuomi.develop.dao;

import org.apache.ibatis.annotations.Param;

import com.tuomi.develop.entity.UserInfo;

public interface UserInfoMapper {

	UserInfo findUserByOpenId(@Param("openId")String id);
	UserInfo getUserById(Long id);
	UserInfo findUserByWeChatId(@Param("wechatId")Long wechatId);
	UserInfo findUserByQQId(@Param("QQId")Long QQId);
	UserInfo findUserById(Long id);
	int edit(UserInfo userinfo);
	int save(UserInfo userInfo);
}
