package com.tuomi.develop.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.dao.RequestDevopsMapper;
import com.tuomi.develop.entity.DevelopPro;
import com.tuomi.develop.entity.RequestDevops;
import com.tuomi.develop.service.RequestDevopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 请求维护serviceImpl类
 * @date 2019/6/3 17:19
 */
@Service
public class RequestDevopsServiceImpl implements RequestDevopsService {

    @Autowired
    private RequestDevopsMapper requestDevopsMapper;

    @Override
    public RequestDevops selectByActivity(Integer number) {
        RequestDevops requestDevops = requestDevopsMapper.selectByActivity(number);
        return requestDevops;
    }
}
