package com.tuomi.develop.service;

import com.tuomi.develop.entity.Tourist;
import org.apache.ibatis.annotations.Param;

public interface TouristService {

    Tourist selectByNameAndPwd(@Param("userName") String name, @Param("passWord") String pwd);
}
