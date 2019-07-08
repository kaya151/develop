package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.PopularizeProMapper;
import com.tuomi.develop.entity.PopularizePro;
import com.tuomi.develop.service.PopularizeProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 推广评估子级serviceImpl类
 * @date 2019/6/4 16:45
 */
@Service
public class PopularizeProServiceImpl implements PopularizeProService {

    @Autowired
    private PopularizeProMapper popularizeProMapper;

    @Override
    public List<PopularizePro> selectList() {
        List<PopularizePro> popularizePros = popularizeProMapper.selectList();
        return popularizePros;
    }

    @Override
    public PopularizePro selectByPrimaryKey(Integer id) {
        PopularizePro popularizePro = popularizeProMapper.selectByPrimaryKey(id);
        return popularizePro;
    }

	@Override
	public int save(PopularizePro pro) {
		return popularizeProMapper.insert(pro);
	}

	@Override
	public int edit(PopularizePro pro) {
		return popularizeProMapper.updateByPrimaryKey(pro);
	}

	@Override
	public int del(Integer id) {
		return popularizeProMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<PopularizePro> getAll() {
		return popularizeProMapper.getAll();
	}
}
