package com.tuomi.develop.service;

import java.util.List;

import com.tuomi.develop.entity.Message;

public interface MessageService {

    int insertSelective(Message record);
    List<Message> getAll();
    int del(Integer id);
}
