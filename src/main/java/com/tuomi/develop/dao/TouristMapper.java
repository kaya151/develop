package com.tuomi.develop.dao;

import com.tuomi.develop.entity.Tourist;
import org.apache.ibatis.annotations.Param;

public interface TouristMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tourist record);

    int insertSelective(Tourist record);

    Tourist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tourist record);

    int updateByPrimaryKey(Tourist record);

    Tourist selectByNameAndPwd(@Param("userName") String name, @Param("passWord") String pwd);
}