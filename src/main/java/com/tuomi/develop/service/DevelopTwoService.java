package com.tuomi.develop.service;

import com.tuomi.develop.entity.DevelopTwo;

import java.util.List;

public interface DevelopTwoService {

    List<DevelopTwo> selectListByFatherId(Integer fatherId);
    List<DevelopTwo> getAll();
    int save(DevelopTwo record);
    int edit(DevelopTwo record);
    int del(Integer id);
    DevelopTwo selectByPrimaryKey(Integer id);
}
