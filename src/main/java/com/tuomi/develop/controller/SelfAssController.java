package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.SelfAss;
import com.tuomi.develop.service.SelfAssService;
import com.tuomi.develop.util.DecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;

/**
 * @version: V1.0
 * @description: 自助评估controller类
 * @date 2019/6/3 14:08
 */
@Controller
public class SelfAssController {

    @Autowired
    private SelfAssService selfAssService;

    /**
     * @version: V1.0
     * @description: 自助评估方法，并存入数据库
     * @date 2019/6/3 14:08
     */
    @RequestMapping(value = "/insertSelfAss",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String insertSelfAss(SelfAss selfAss){
        String toJSONString = "";
        BaseResult baseResult = null;
        if(selfAss!=null){
            selfAss.setDevelomentCost((float) ((0.25*selfAss.getDevelopmentTime())*(2-selfAss.getCompletionRate())*((7000*selfAss.getFrontNumber())+(8000*selfAss.getBackNumber()))*2.17*1.15)/10000);
            int i = selfAssService.insertSelective(selfAss);
            String devCost = DecimalUtil.getRounding(selfAss.getDevelomentCost());
            baseResult = new BaseResult(1,Constant.success,devCost);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
}
