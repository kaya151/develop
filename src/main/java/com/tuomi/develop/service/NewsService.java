package com.tuomi.develop.service;


import com.tuomi.develop.entity.News;

import java.util.List;

public interface NewsService {
    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int deleteAll();

    List<News> selectAll();
}
