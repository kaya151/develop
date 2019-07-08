package com.tuomi.develop.dao;

import com.tuomi.develop.entity.ManualAss;

import java.util.List;

public interface ManualAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManualAss record);

    int insertSelective(ManualAss record);

    ManualAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManualAss record);

    int updateByPrimaryKey(ManualAss record);

    List<ManualAss> selectManualByUserId(Integer userId);

    List<ManualAss> selectAll();

    List<ManualAss> selectNoResp();

    List<ManualAss> selectResp();
}