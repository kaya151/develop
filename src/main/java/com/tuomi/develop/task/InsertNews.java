package com.tuomi.develop.task;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tuomi.develop.entity.News;
import com.tuomi.develop.service.NewsService;
import com.tuomi.develop.util.NewsUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @version: V1.0
 * @description: 每天三点半更新数据库50条新闻
 * @date 2019/6/25 10:10
 */
@Component
public class InsertNews {

    @Autowired
    private NewsService newsService;

    @Scheduled(cron = "0 30 03 ? * *")
    public void getNews(){
        newsService.deleteAll();
        String url = "http://api01.idataapi.cn:8000/article/idataapi?KwPosition=3&appCode=163.com,qq.com,toutiao.com&sourceType=APP&size=50&catLabel1=科技&apikey=RtX27pyCicSZh5j9nf1Oj7MLuAWGw3wwYF52VtIgTPsMEsTrjhuXTmJykAXMEB4i";
        try {
            JSONObject jsonNews = NewsUtil.getRequestFromUrl(url);
            Object retcode = jsonNews.get("retcode");
            if (retcode != null) {
                if (retcode.equals("000000")) { //返回状态码"000000"表示正常
//                   //接口返回正常 数据存入数据库
                    JSONArray data = jsonNews.getJSONArray("data");
                    Iterator iterator = data.iterator();
                    while (iterator.hasNext()) {
                        News news = new News();
                        JSONObject oneNews = (JSONObject) iterator.next();
                        String title = (String) oneNews.get("title");
                        news.setNewsTitle(title);
                        String content = (String) oneNews.get("html");
                        news.setNewsContent(content);
                        if (oneNews.getJSONArray("imageUrls")!=null && oneNews.getJSONArray("imageUrls").size()>0){
                            JSONArray imageUrls = oneNews.getJSONArray("imageUrls");
                            String imageUrls1 = (String) imageUrls.get(0);
                            news.setImageUrls(imageUrls1);
                        }
                        Integer createDate = (Integer) oneNews.get("createDate");
                        news.setCreateDate(String.valueOf(createDate));
                        String appName = (String) oneNews.get("appName");
                        news.setAppName(appName);
                        newsService.insertSelective(news);
                    }

                } else { // 其它返回状态码,表示无法继续
                    System.out.println(jsonNews.getString("message")); //打印状态信息
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
