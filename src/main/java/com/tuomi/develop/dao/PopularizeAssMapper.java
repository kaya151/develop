package com.tuomi.develop.dao;

import com.tuomi.develop.entity.PopularizeAss;

import java.util.List;

public interface PopularizeAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PopularizeAss record);

    int insertSelective(PopularizeAss record);

    PopularizeAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PopularizeAss record);

    int updateByPrimaryKey(PopularizeAss record);

    List<PopularizeAss> selectList();
}