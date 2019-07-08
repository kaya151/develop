package com.tuomi.develop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuomi.develop.dao.UserInfoMapper;
import com.tuomi.develop.entity.UserInfo;
import com.tuomi.develop.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public int save(UserInfo userInfo) {
		
		return userInfoMapper.save(userInfo);
	}

	@Override
	public UserInfo getUserById(Long id) {
		// TODO Auto-generated method stub
		return userInfoMapper.getUserById(id);
	}

	@Override
	public UserInfo findUserByWeChatId(Long wechatId) {
		
		return userInfoMapper.findUserByWeChatId(wechatId);
	}

	@Override
	public UserInfo findUserByQQId(Long QQId) {
		return userInfoMapper.findUserByQQId(QQId);
	}

	@Override
	public UserInfo findUserById(Long id) {
		return userInfoMapper.findUserById(id);
	}

	@Override
	public int edit(UserInfo userinfo) {
		return userInfoMapper.edit(userinfo);
	}

}
