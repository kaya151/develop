package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.entity.Notice;
import com.tuomi.develop.entity.User;
import com.tuomi.develop.service.NoticeService;
import com.tuomi.develop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @description: 消息类
 * @date 2019/6/25 11:12
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectNoticeList", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public String selectNoticeList(Integer userId) {
        BaseResult baseResult = null;
        String toJSONString = "";
        List<List<Notice>> list = new ArrayList<>();
        List<String> NoticeTime = noticeService.selectNoticeTime(userId);
        System.out.println("NoticeTime============="+NoticeTime);
        User user = userService.selectByPrimaryKey(userId);
        user.setStatus(1);
        int i = userService.updateByPrimaryKeySelective(user);
        if (NoticeTime !=null && NoticeTime.size()>0){
            for (String replyTime:NoticeTime) {
                List<Notice> notices = noticeService.selectByTimeAndUserId(replyTime,userId);
                list.add(notices);
            }
            baseResult = new BaseResult(1, "有数据",list);
            toJSONString = JSON.toJSONString(baseResult);
        }else{
            baseResult = new BaseResult(0, "没有数据");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
}
