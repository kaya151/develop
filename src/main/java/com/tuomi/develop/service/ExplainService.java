package com.tuomi.develop.service;

import com.tuomi.develop.entity.Explain;

import java.util.List;

public interface ExplainService {

    List<Explain> selectByCategory(String category);
    List<Explain> getExplainAll();
    int save(Explain record);
    int edit(Explain record);
    int del(Integer id);
}
