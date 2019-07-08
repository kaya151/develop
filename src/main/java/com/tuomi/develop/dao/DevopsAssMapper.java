package com.tuomi.develop.dao;

import com.tuomi.develop.entity.DevopsAss;

public interface DevopsAssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevopsAss record);

    int insertSelective(DevopsAss record);

    DevopsAss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevopsAss record);

    int updateByPrimaryKey(DevopsAss record);
}