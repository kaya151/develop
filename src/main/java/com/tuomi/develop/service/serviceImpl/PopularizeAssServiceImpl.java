package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.PopularizeAssMapper;
import com.tuomi.develop.entity.PopularizeAss;
import com.tuomi.develop.service.PopularizeAssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 推广评估父级serviceImpl类
 * @date 2019/6/4 16:45
 */
@Service
public class PopularizeAssServiceImpl implements PopularizeAssService {

    @Autowired
    private PopularizeAssMapper popularizeAssMapper;

    @Override
    public List<PopularizeAss> selectList() {
        List<PopularizeAss> popularizeAsses = popularizeAssMapper.selectList();
        return popularizeAsses;
    }

	@Override
	public int del(Integer id) {
		return popularizeAssMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(PopularizeAss popularizeAss) {
		return popularizeAssMapper.insert(popularizeAss);
	}

	@Override
	public int edit(PopularizeAss popularizeAss) {
		return popularizeAssMapper.updateByPrimaryKey(popularizeAss);
	}

	@Override
	public List<PopularizeAss> getAll() {
		return popularizeAssMapper.selectList();
	}

	@Override
	public PopularizeAss selectByPrimaryKey(Integer id) {
		return popularizeAssMapper.selectByPrimaryKey(id);
	}
}
