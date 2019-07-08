package com.tuomi.develop.dao;

import com.tuomi.develop.entity.RequestDevops;

public interface RequestDevopsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RequestDevops record);

    int insertSelective(RequestDevops record);

    RequestDevops selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RequestDevops record);

    int updateByPrimaryKey(RequestDevops record);

    RequestDevops selectByActivity(Integer number);
}