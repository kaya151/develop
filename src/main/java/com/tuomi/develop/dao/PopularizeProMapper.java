package com.tuomi.develop.dao;

import com.tuomi.develop.entity.PopularizePro;

import java.util.List;

public interface PopularizeProMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PopularizePro record);

    int insertSelective(PopularizePro record);

    PopularizePro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PopularizePro record);

    int updateByPrimaryKey(PopularizePro record);

    List<PopularizePro> selectList();
    List<PopularizePro> getAll();
}