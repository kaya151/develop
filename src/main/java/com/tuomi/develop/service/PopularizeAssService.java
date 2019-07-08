package com.tuomi.develop.service;

import com.tuomi.develop.entity.PopularizeAss;

import java.util.List;

public interface PopularizeAssService {

    List<PopularizeAss> selectList();
    int del(Integer id);
    int save(PopularizeAss popularizeAss);
    int edit(PopularizeAss popularizeAss);
    List<PopularizeAss> getAll();
    PopularizeAss selectByPrimaryKey(Integer id);
}
