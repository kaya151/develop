package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.service.UserService;
import com.tuomi.develop.util.RandomNumUtil;
import com.tuomi.develop.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @version: V1.0
 * @description: 短信类
 * @date 2019/6/25 11:12
 */
@Controller
public class SmsController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getSmsCode",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String getSmsCode(String tel,HttpSession session){
        BaseResult baseResult = null;
        String toJSONString = "";
        List<String> tels = userService.selectAllTel();
        for (String tel1:tels) {
            if (tel.equals(tel1)){
                baseResult = new BaseResult(0,"手机号已绑定");
                toJSONString = JSON.toJSONString(baseResult);
                return toJSONString;
            }
        }
        String randomNum = RandomNumUtil.getRandomNum();
        System.out.println("randomNum==+++++++++=="+randomNum);
        String sms = SmsUtil.getSms(randomNum,tel);
        if (sms.equals("0")){
            baseResult = new BaseResult(1,"短信发送成功",randomNum);
            session.setAttribute(tel,randomNum);
            toJSONString = JSON.toJSONString(baseResult);
        }else if (sms.equals("41")){
            baseResult = new BaseResult(0,"余额不足");
            toJSONString = JSON.toJSONString(baseResult);
        }else if (sms.equals("51")){
            baseResult = new BaseResult(0,"手机号码不正确");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
}
