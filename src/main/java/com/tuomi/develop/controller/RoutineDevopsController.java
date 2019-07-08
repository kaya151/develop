package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.RoutineDevops;
import com.tuomi.develop.service.RoutineDevopsService;
import com.tuomi.develop.util.DecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
/**
 * @version: V1.0
 * @description: 常规维护controller类
 * @date 2019/6/3 17:20
 */
@Controller
public class RoutineDevopsController {

    @Autowired
    private RoutineDevopsService routineDevopsService;

    /**
     * @version: V1.0
     * @description: 通过1年内开发总金额查询维护费的方法
     * @date 2019/6/3 17:20
     */
    @RequestMapping(value = "/selectByDeveopMoney",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByDeveopMoney(RoutineDevops routineDevops){
        routineDevops.setDevopsCost((float) (routineDevops.getDevelopmentMoney()*0.2/12));
        int i = routineDevopsService.insertSelective(routineDevops);
        String devCost = DecimalUtil.getRounding(routineDevops.getDevopsCost());
        BaseResult baseResult = new BaseResult(1,Constant.success,devCost);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
}
