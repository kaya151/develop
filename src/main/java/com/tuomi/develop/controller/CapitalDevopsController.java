package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.CapitalDevops;
import com.tuomi.develop.service.CapitalDevopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 资金评估controller类
 * @date 2019/6/3 17:15
 */
@Controller
public class CapitalDevopsController {

    @Autowired
    private CapitalDevopsService capitalDevopsService;

    /**
     * @version: V1.0
     * @description: 通过交易额查询维护费的方法
     * @date 2019/6/3 17:15
     */
    @RequestMapping(value = "/selectByTurnover",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByTurnover(Integer number){
        CapitalDevops capitalDevops = capitalDevopsService.selectByTurnover(number);
        BaseResult baseResult = new BaseResult(1,Constant.success,capitalDevops);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
}
