package com.tuomi.develop.dao;

import com.tuomi.develop.entity.DevelopPro;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DevelopProMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevelopPro record);
    
    int insertSelective(DevelopPro record);

    DevelopPro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevelopPro record);

    int updateByPrimaryKey(DevelopPro record);

    List<DevelopPro> selectListByTwoId(Integer twoId);

    List<DevelopPro> selectListByFatherId(Integer fatherId);
    List<DevelopPro> getPrByFidAndTid(@Param("fid")Integer fatherId,@Param("tid")Integer twoId);
    void editPr(DevelopPro developPro);
    List<DevelopPro> findPrByFid(@Param("fid")Integer fid);
    List<DevelopPro> getAll();
}