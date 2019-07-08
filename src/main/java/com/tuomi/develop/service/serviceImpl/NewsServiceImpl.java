package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.NewsMapper;
import com.tuomi.develop.entity.News;
import com.tuomi.develop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 新闻类
 * @date 2019/6/25 11:14
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int insertSelective(News record) {
        int i = newsMapper.insertSelective(record);
        return i;
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        News news = newsMapper.selectByPrimaryKey(id);
        return news;
    }

    @Override
    public int deleteAll() {
        int i = newsMapper.deleteAll();
        return i;
    }

    @Override
    public List<News> selectAll() {
        List<News> news = newsMapper.selectAll();
        return news;
    }
}
