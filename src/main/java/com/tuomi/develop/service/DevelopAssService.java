package com.tuomi.develop.service;

import com.tuomi.develop.entity.DevelopAss;

import java.util.List;

public interface DevelopAssService {

    List<DevelopAss> selectList();
    int save(DevelopAss record);
    int edit(DevelopAss record);
    List<DevelopAss> getAll();
    int del(Integer id);
    List<DevelopAss> getAllByType();
    DevelopAss selectByPrimaryKey(Integer id);
}
