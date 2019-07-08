package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.SelfAssMapper;
import com.tuomi.develop.entity.SelfAss;
import com.tuomi.develop.service.SelfAssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 自助评估serviceImpl类
 * @date 2019/6/3 14:09
 */
@Service
public class SelfAssServiceImpl implements SelfAssService {

    @Autowired
    private SelfAssMapper selfAssMapper;

    @Override
    public int insertSelective(SelfAss record) {
        int i = selfAssMapper.insertSelective(record);
        return i;
    }
}
