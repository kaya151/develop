package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.entity.User;
import com.tuomi.develop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @description: 用户授权登陆controller类
 * @date 2019/6/6 9:41
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @version: V1.0
     * @description: 添加用户方法
     * @date 2019/6/6 9:41
     */
    @RequestMapping(value = "/insertUser",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String insertUser(User user){
        String toJSONString = "";
        BaseResult baseResult = null;
        User user1 = userService.selectByOpenId(user.getOpenId());
        if (user1 == null){
            user.setIsTel(0);
            int i = userService.insertSelective(user);
            User user2 = userService.selectByOpenId(user.getOpenId());
            baseResult = new BaseResult(1,"访问成功，添加到数据库",user2);
            toJSONString = JSON.toJSONString(baseResult);
        }else{
            user.setId(user1.getId());
            int i = userService.updateByPrimaryKeySelective(user);
            if (user1.getTel() != null && user1.getTel() != ""){
                baseResult = new BaseResult(1,"访问成功,有电话号码",user1);
                toJSONString = JSON.toJSONString(baseResult);
            }else {
                baseResult = new BaseResult(1,"访问成功,无电话号码",user1);
                toJSONString = JSON.toJSONString(baseResult);
            }
        }
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据openId查询用户
     * @date 2019/6/6 9:57
     */
    @RequestMapping(value = "/selectByOpenId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByOpenId(String openId){
        System.out.println("openid方法执行了1次");
        User user = userService.selectByOpenId(openId);
        BaseResult baseResult = null;
        String toJSONString = "";
        if (user!=null){
            baseResult = new BaseResult(1,"访问成功",user);
            toJSONString = JSON.toJSONString(baseResult);
        }else {
            baseResult = new BaseResult(0,"没有该用户");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }

    @RequestMapping(value = "/selectByUserId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByUserId(Integer id){
        BaseResult baseResult = null;
        String toJSONString = "";
        if (id != null){
            User user = userService.selectByPrimaryKey(id);
            baseResult = new BaseResult(1,"success",user);
            toJSONString = JSON.toJSONString(baseResult);
        }else {
            baseResult = new BaseResult(0,"error");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
    /**
     * 
     * @param session
     * @param id 用户id
     * @param tel 电话
     * @param randomNum 验证码
     * @return
     */
    @RequestMapping(value = "/updataUser",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String updataUser(HttpSession session, Integer id, String tel, String randomNum){
        String toJSONString = "";
        BaseResult baseResult = null;
        System.out.println("手机号可以绑定");
        String frontRandomNum = (String) session.getAttribute(tel);
        if (randomNum.equals(frontRandomNum)){
            User user = userService.selectByPrimaryKey(id);
            user.setTel(tel);
            user.setIsTel(1);
            int i = userService.updateByPrimaryKeySelective(user);
            if (i == 1){
                User user1 = userService.selectByPrimaryKey(id);
                baseResult = new BaseResult(1,"手机号绑定成功",user1);
                toJSONString = JSON.toJSONString(baseResult);
            }else {
                baseResult = new BaseResult(0,"手机号绑定失败");
                toJSONString = JSON.toJSONString(baseResult);
            }
        }else {
            baseResult = new BaseResult(0,"验证码错误");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
    
    @RequestMapping("/getAllUser")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int page,
    		@RequestParam(defaultValue = "20",value = "limit",required=true)int limit){
    	PageHelper.startPage(page, limit);
    	List<User> list = userService.getAll();
    	PageInfo<User> info = new PageInfo<>(list);
    	Map<String, Object> map=new HashMap<>();
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getSize());
    	map.put("data", info.getList());
    	return map;
    }
    
    
    
}
