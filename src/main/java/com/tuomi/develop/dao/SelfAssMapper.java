package com.tuomi.develop.dao;

import com.tuomi.develop.entity.SelfAss;

public interface SelfAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelfAss record);

    int insertSelective(SelfAss record);

    SelfAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelfAss record);

    int updateByPrimaryKey(SelfAss record);
}