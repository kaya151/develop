package com.tuomi.develop.dao;

import com.tuomi.develop.entity.DevelopTwo;

import java.util.List;

public interface DevelopTwoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevelopTwo record);

    int insertSelective(DevelopTwo record);

    DevelopTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevelopTwo record);

    int updateByPrimaryKey(DevelopTwo record);

    List<DevelopTwo> selectListByFatherId(Integer fatherId);
    List<DevelopTwo> getAll();
}