package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.News;
import com.tuomi.develop.service.NewsService;
import com.tuomi.develop.service.serviceImpl.NewsServiceImpl;
import com.tuomi.develop.util.NewsUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @version: V1.0
 * @description: 新闻controller类
 * @date 2019/6/4 10:50
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/getNews",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String getNews(){
        List<News> news = newsService.selectAll();
        BaseResult baseResult = null;
        String toJSONString = "";
        if (news != null && news.size()>0){
            for (News news1:news) {
                news1.setNewsContent("");
                news1.setUrls("47.99.138.92:8081/develop/news.html?id="+news1.getId());
                baseResult = new BaseResult(1,Constant.success,news);
                toJSONString = JSON.toJSONString(baseResult);
            }
        }else{
            baseResult = new BaseResult(0,Constant.error);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }

    @RequestMapping(value = "/getOneNews")
    @ResponseBody
    public String getOneNews(String callback , Integer id){
        News news = newsService.selectByPrimaryKey(id);
        BaseResult baseResult = null;
        String toJSONString = "";
        if (news != null){
            baseResult = new BaseResult(1,Constant.success,news);
            toJSONString = JSON.toJSONString(baseResult);
        }else{
            baseResult = new BaseResult(0,Constant.error);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return callback+"("+toJSONString+")";
    }

}
