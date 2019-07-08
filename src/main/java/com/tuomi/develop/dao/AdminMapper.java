package com.tuomi.develop.dao;

import com.tuomi.develop.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByNameAndPwd(@Param("username") String username,@Param("password") String password);

    Admin selectByName(String username);
}