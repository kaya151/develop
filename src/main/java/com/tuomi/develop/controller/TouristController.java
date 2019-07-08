package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.Tourist;
import com.tuomi.develop.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 账号密码登陆controller类
 * @date 2019/6/6 17:21
 */
@Controller
public class TouristController {
    @Autowired
    private TouristService adminService;

    /**
     * @version: V1.0
     * @description: 通过账号密码登陆的方法
     * @date 2019/6/17 15:12
     */
    @RequestMapping(value = "/selectByNameAndPwd",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByNameAndPwd(String name , String pwd){
        Tourist tourist = adminService.selectByNameAndPwd(name, pwd);
        String toJSONString = "";
        BaseResult baseResult = null;
        if (tourist != null){
            baseResult = new BaseResult(1,Constant.success,tourist);
            toJSONString = JSON.toJSONString(baseResult);
        }else{

            baseResult = new BaseResult(0,Constant.error,tourist);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
}
