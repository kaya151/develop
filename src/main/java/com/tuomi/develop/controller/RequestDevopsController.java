package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.RequestDevops;
import com.tuomi.develop.entity.SelfAss;
import com.tuomi.develop.service.RequestDevopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 请求维护controller类
 * @date 2019/6/3 17:18
 */
@Controller
public class RequestDevopsController {

    @Autowired
    private RequestDevopsService requestDevopsService;

    /**
     * @version: V1.0
     * @description: 通过日活量查询维护费的方法
     * @date 2019/6/3 17:19
     */
    @RequestMapping(value = "/selectByActivity",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByActivity(Integer number){
        RequestDevops requestDevops = requestDevopsService.selectByActivity(number);
        BaseResult baseResult = new BaseResult(1,Constant.success,requestDevops);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
}
