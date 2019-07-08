package com.tuomi.develop.service;

import com.tuomi.develop.entity.ManualAss;

import java.util.List;

public interface ManualAssService {

    int insertSelective(ManualAss record);

    List<ManualAss> selectManualByUserId(Integer userId);

    List<ManualAss> selectAll();

    List<ManualAss> selectNoResp();

    List<ManualAss> selectResp();

    ManualAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManualAss record);

    int deleteByPrimaryKey(Integer id);
}
