package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.AdminMapper;
import com.tuomi.develop.entity.Admin;
import com.tuomi.develop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 管理员类
 * @date 2019/6/25 11:13
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByNameAndPwd(String username, String password) {
        Admin admin = adminMapper.selectByNameAndPwd(username, password);
        return admin;
    }

    @Override
    public Admin selectByName(String username) {
        Admin admin = adminMapper.selectByName(username);
        return admin;
    }

    @Override
    public int insertSelective(Admin record) {
        int i = adminMapper.insertSelective(record);
        return i;
    }
}
