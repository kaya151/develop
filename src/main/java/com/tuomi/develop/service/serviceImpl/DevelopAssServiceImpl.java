package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.DevelopAssMapper;
import com.tuomi.develop.entity.DevelopAss;
import com.tuomi.develop.service.DevelopAssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 开发评估父级serviceImpl类
 * @date 2019/6/4 16:43
 */
@Service
public class DevelopAssServiceImpl implements DevelopAssService {

    @Autowired
    private DevelopAssMapper developAssMapper;

    @Override
    public List<DevelopAss> selectList() {
        List<DevelopAss> developAsses = developAssMapper.selectList();
        return developAsses;
    }

	@Override
	public int save(DevelopAss record) {
		
		return developAssMapper.insertSelective(record);
	}

	@Override
	public int edit(DevelopAss record) {
		
		return developAssMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<DevelopAss> getAll() {
		
		return developAssMapper.getAll();
	}

	@Override
	public int del(Integer id) {
		
		return developAssMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<DevelopAss> getAllByType() {
		
		return developAssMapper.getAllByType();
	}

	@Override
	public DevelopAss selectByPrimaryKey(Integer id) {
		return developAssMapper.selectByPrimaryKey(id);
	}
}
