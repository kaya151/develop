package com.tuomi.develop.dao;

import com.tuomi.develop.entity.Explain;

import java.util.List;

public interface ExplainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Explain record);

    int insertSelective(Explain record);
    int updateByPrimaryKeySelective(Explain record);
    Explain selectByPrimaryKey(Integer id);

    

    int updateByPrimaryKey(Explain record);

    List<Explain> selectByCategory(String category);
    List<Explain> getExplainAll();
}