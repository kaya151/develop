package com.tuomi.develop.service;

import com.tuomi.develop.entity.PopularizePro;

import java.util.List;

public interface PopularizeProService {

    List<PopularizePro> selectList();
    PopularizePro selectByPrimaryKey(Integer id);
    int save(PopularizePro pro);
    int edit(PopularizePro pro);
    int del(Integer id);
    List<PopularizePro> getAll();
}
