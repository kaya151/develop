package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.Status;
import com.tuomi.develop.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 登陆所需状态类
 * @date 2019/6/25 11:12
 */
@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/selectStatus",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectStatus(){
        Status status = statusService.selectByPrimaryKey(1);
        BaseResult baseResult = new BaseResult(1,Constant.success,status);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
}
