package com.tuomi.develop.dao;

import com.tuomi.develop.entity.DevelopAss;

import java.util.List;

public interface DevelopAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevelopAss record);

    int insertSelective(DevelopAss record);

    DevelopAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevelopAss record);

    int updateByPrimaryKey(DevelopAss record);

    List<DevelopAss> selectList();
    List<DevelopAss> getAll();
    List<DevelopAss> getAllByType();
}