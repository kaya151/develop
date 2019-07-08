package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.CapitalDevopsMapper;
import com.tuomi.develop.entity.CapitalDevops;
import com.tuomi.develop.service.CapitalDevopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 资金评估的serviceImpl类
 * @date 2019/6/3 17:17
 */
@Service
public class CapitalDevopsServiceImpl implements CapitalDevopsService {

    @Autowired
    private CapitalDevopsMapper capitalDevopsMapper;


    @Override
    public CapitalDevops selectByTurnover(Integer number) {
        CapitalDevops capitalDevops = capitalDevopsMapper.selectByTurnover(number);
        return capitalDevops;
    }
}
