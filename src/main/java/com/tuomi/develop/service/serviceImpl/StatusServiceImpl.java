package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.StatusMapper;
import com.tuomi.develop.entity.Status;
import com.tuomi.develop.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 登陆所需状态类
 * @date 2019/6/25 11:14
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public Status selectByPrimaryKey(Integer id) {
        Status status = statusMapper.selectByPrimaryKey(id);
        return status;
    }
}
