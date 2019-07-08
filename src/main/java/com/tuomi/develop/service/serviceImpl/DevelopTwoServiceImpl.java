package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.DevelopTwoMapper;
import com.tuomi.develop.entity.DevelopTwo;
import com.tuomi.develop.service.DevelopTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 开发评估二级页面serviceImpl类
 * @date 2019/6/4 16:44
 */
@Service
public class DevelopTwoServiceImpl implements DevelopTwoService {

    @Autowired
    private DevelopTwoMapper developTwoMapper;

    @Override
    public List<DevelopTwo> selectListByFatherId(Integer fatherId) {
        List<DevelopTwo> developTwos = developTwoMapper.selectListByFatherId(fatherId);
        return developTwos;
    }

	@Override
	public List<DevelopTwo> getAll() {
		
		return developTwoMapper.getAll();
	}

	@Override
	public int save(DevelopTwo record) {
		return developTwoMapper.insert(record);
	}

	@Override
	public int edit(DevelopTwo record) {
		return developTwoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int del(Integer id) {
		return developTwoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DevelopTwo selectByPrimaryKey(Integer id) {
		
		return developTwoMapper.selectByPrimaryKey(id);
	}
}
