package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.MessageMapper;
import com.tuomi.develop.entity.Message;
import com.tuomi.develop.service.MessageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @version: V1.0
 * @description: 留言serviceImpl类
 * @date 2019/6/6 10:52
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int insertSelective(Message record) {
        int i = messageMapper.insertSelective(record);
        return i;
    }

	@Override
	public List<Message> getAll() {
		
		return messageMapper.getAll();
	}

	@Override
	public int del(Integer id) {
		return messageMapper.deleteByPrimaryKey(id);
	}
}
