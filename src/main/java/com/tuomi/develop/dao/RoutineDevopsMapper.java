package com.tuomi.develop.dao;

import com.tuomi.develop.entity.RoutineDevops;

public interface RoutineDevopsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoutineDevops record);

    int insertSelective(RoutineDevops record);

    RoutineDevops selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoutineDevops record);

    int updateByPrimaryKey(RoutineDevops record);

    RoutineDevops selectByDeveopMoney(Integer number);
}