package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.UserMapper;
import com.tuomi.develop.entity.User;
import com.tuomi.develop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @description: 用户serviceImpl方法
 * @date 2019/6/6 9:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertSelective(User record) {
        int i = userMapper.insertSelective(record);
        return i;
    }

    @Override
    public User selectByOpenId(String openId) {
        User user = userMapper.selectByOpenId(openId);
        return user;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int i = userMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public List<String> selectAllTel() {
        List<String> tels = userMapper.selectAllTel();
        return tels;
    }

	@Override
	public List<User> getAll() {
		
		return userMapper.getAll();
	}
}
