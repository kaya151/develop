package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.RoutineDevopsMapper;
import com.tuomi.develop.entity.RoutineDevops;
import com.tuomi.develop.service.RoutineDevopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 常规维护serviceImpl类
 * @date 2019/6/3 17:20
 */
@Service
public class RoutineDevopsServiceImpl implements RoutineDevopsService {

    @Autowired
    private RoutineDevopsMapper routineDevopsMapper;


    @Override
    public int insertSelective(RoutineDevops record) {
        int i = routineDevopsMapper.insertSelective(record);
        return i;
    }
}
