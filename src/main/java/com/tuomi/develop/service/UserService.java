package com.tuomi.develop.service;

import com.tuomi.develop.entity.User;

import java.util.List;

public interface UserService {

    int insertSelective(User record);

    User selectByOpenId(String openId);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    List<String> selectAllTel();
    List<User> getAll();
}
