package com.tuomi.develop.service;

import com.tuomi.develop.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {

    Admin selectByNameAndPwd( String username,  String password);

    Admin selectByName(String username);

    int insertSelective(Admin record);
}
