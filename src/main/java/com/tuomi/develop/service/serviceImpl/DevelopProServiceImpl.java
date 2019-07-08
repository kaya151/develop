package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.DevelopProMapper;
import com.tuomi.develop.entity.DevelopPro;
import com.tuomi.develop.service.DevelopProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @description: 开发评估子级serviceImpl类
 * @date 2019/6/3 17:18
 */
@Service
public class DevelopProServiceImpl implements DevelopProService {

    @Autowired
    private DevelopProMapper developProMapper;

    @Override
    public DevelopPro selectByPrimaryKey(Integer id) {
        DevelopPro developPro = developProMapper.selectByPrimaryKey(id);
        return developPro;
    }

    @Override
    public List<DevelopPro> selectListByTwoId(Integer twoId) {
        List<DevelopPro> developPros = developProMapper.selectListByTwoId(twoId);
        return developPros;
    }

    @Override
    public List<DevelopPro> selectListByFatherId(Integer fatherId) {
        List<DevelopPro> developPros = developProMapper.selectListByFatherId(fatherId);
        return developPros;
    }

	@Override
	public List<DevelopPro> getPrByFidAndTid(Integer fatherId, Integer twoId) {
		
		return developProMapper.getPrByFidAndTid(fatherId, twoId);
	}

	@Override
	public void editPr(DevelopPro developPro) {
		developProMapper.editPr(developPro);
	}

	@Override
	public List<DevelopPro> findPrByFid(Integer fid) {
		
		return developProMapper.findPrByFid(fid);
	}

	@Override
	public List<DevelopPro> getAll() {
		return developProMapper.getAll();
	}

	@Override
	public int save(DevelopPro pro) {
		return developProMapper.insert(pro);
	}

	@Override
	public int edit(DevelopPro pro) {
		return developProMapper.updateByPrimaryKey(pro);
	}

	@Override
	public int del(Integer id) {
		return developProMapper.deleteByPrimaryKey(id);
	}
}
