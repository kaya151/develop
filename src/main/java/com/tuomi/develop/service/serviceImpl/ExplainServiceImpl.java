package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.ExplainMapper;
import com.tuomi.develop.entity.Explain;
import com.tuomi.develop.service.ExplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 名词解释serviceImpl类
 * @date 2019/6/6 10:53
 */
@Service
public class ExplainServiceImpl implements ExplainService {

    @Autowired
    private ExplainMapper explainMapper;

    @Override
    public List<Explain> selectByCategory(String category) {
        List<Explain> explains = explainMapper.selectByCategory(category);
        return explains;
    }

	@Override
	public List<Explain> getExplainAll() {
		
		return explainMapper.getExplainAll();
	}

	@Override
	public int save(Explain record) {
		
		return explainMapper.insertSelective(record);
	}

	@Override
	public int edit(Explain record) {
		
		return explainMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int del(Integer id) {
		
		return explainMapper.deleteByPrimaryKey(id);
	}
}
