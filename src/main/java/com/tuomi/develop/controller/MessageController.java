package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.entity.Message;
import com.tuomi.develop.service.MessageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 留言controller类
 * @date 2019/6/6 10:50
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * @version: V1.0
     * @description: 添加留言方法
     * @date 2019/6/6 10:51
     */
    @RequestMapping(value = "/insertMessage",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String insertMessage(Message message){
        int i = messageService.insertSelective(message);
        BaseResult baseResult = new BaseResult(1,"success",message);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: 需求管理的所有数据分页
     * @date 2019/7/1 
     */
    @RequestMapping("/getMessageAll")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int page,
    		@RequestParam(defaultValue = "20",value = "limit",required=true)int limit){
    	PageHelper.startPage(page, limit);
    	List<Message> list = messageService.getAll();
    	PageInfo<Message> info = new PageInfo<>(list);
    	Map<String, Object> map=new HashMap<>();
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getSize());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 需求管理的删除
     * @date 2019/7/1 
     */
    @RequestMapping("/getMessageDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map=new HashMap<>();
    	try {
    		messageService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    
}
