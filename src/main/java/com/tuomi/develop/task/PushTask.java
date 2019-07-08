package com.tuomi.develop.task;


import com.tuomi.develop.entity.News;
import com.tuomi.develop.push.PushIos;

import com.tuomi.develop.service.NewsService;
import com.tuomi.develop.util.TheLogger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @version: V1.0
 * @description: 定时任务类，群发推送
 * @date 2019/6/11 11:50
 */
@Component
public class PushTask {

    @Autowired
    private NewsService newsService;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TheLogger.class);

    DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 kk时mm分ss秒");

    
    @Scheduled(cron = "0 53 10 ? * *")
    public void sendNewsPush() {
        log.info("=====>>>>>使用fixedRate{}", dateFormat.format(System.currentTimeMillis()) );
        News news = newsService.selectByPrimaryKey(1);
        PushIos pushIos = new PushIos();
        try {
            pushIos.sendIOSBroadcast(news.getNewsTitle(),String.valueOf(news.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
