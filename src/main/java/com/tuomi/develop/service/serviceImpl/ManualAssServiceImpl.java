package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.ManualAssMapper;
import com.tuomi.develop.entity.ManualAss;
import com.tuomi.develop.service.ManualAssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @description: 人工评估serviceImpl类
 * @date 2019/6/4 16:45
 */
@Service
public class ManualAssServiceImpl implements ManualAssService {

    @Autowired
    private ManualAssMapper manualAssMapper;

    @Override
    public int insertSelective(ManualAss record) {
        int i = manualAssMapper.insertSelective(record);
        return i;
    }

    @Override
    public List<ManualAss> selectManualByUserId(Integer userId) {
        List<ManualAss> manualAsses = manualAssMapper.selectManualByUserId(userId);
        return manualAsses;
    }

    @Override
    public List<ManualAss> selectAll() {
        List<ManualAss> manualAsses = manualAssMapper.selectAll();
        return manualAsses;
    }

    @Override
    public List<ManualAss> selectNoResp() {
        List<ManualAss> manualAsses = manualAssMapper.selectNoResp();
        return manualAsses;
    }

    @Override
    public List<ManualAss> selectResp() {
        List<ManualAss> manualAsses = manualAssMapper.selectResp();
        return manualAsses;
    }

    @Override
    public ManualAss selectByPrimaryKey(Integer id) {
        ManualAss manualAss = manualAssMapper.selectByPrimaryKey(id);
        return manualAss;
    }

    @Override
    public int updateByPrimaryKeySelective(ManualAss record) {
        int i = manualAssMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = manualAssMapper.deleteByPrimaryKey(id);
        return i;
    }
}
