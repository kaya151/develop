package com.tuomi.develop.dao;

import com.tuomi.develop.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    int deleteAll();

    List<News> selectAll();
}