package com.tuomi.develop.dao;

import com.tuomi.develop.entity.CapitalDevops;

public interface CapitalDevopsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CapitalDevops record);

    int insertSelective(CapitalDevops record);

    CapitalDevops selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CapitalDevops record);

    int updateByPrimaryKey(CapitalDevops record);

    CapitalDevops selectByTurnover(Integer number);
}