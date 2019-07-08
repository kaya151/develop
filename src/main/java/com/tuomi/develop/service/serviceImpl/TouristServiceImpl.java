package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.TouristMapper;
import com.tuomi.develop.entity.Tourist;
import com.tuomi.develop.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 账号密码登陆
 * @date 2019/6/6 17:22
 */
@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    private TouristMapper touristMapper;

    @Override
    public Tourist selectByNameAndPwd(String name, String pwd) {
        Tourist tourist = touristMapper.selectByNameAndPwd(name, pwd);
        return tourist;
    }
}
