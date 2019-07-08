package com.tuomi.develop.service;

import com.tuomi.develop.entity.DevelopPro;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DevelopProService {

    DevelopPro selectByPrimaryKey(Integer id);

    List<DevelopPro> selectListByTwoId(Integer twoId);

    List<DevelopPro> selectListByFatherId(Integer fatherId);
    List<DevelopPro> getPrByFidAndTid(Integer fatherId,Integer twoId);
    void editPr(DevelopPro developPro);
    List<DevelopPro> findPrByFid(Integer fid);
    List<DevelopPro> getAll();
    int save(DevelopPro pro);
    int edit(DevelopPro pro);
    int del(Integer id);
}
