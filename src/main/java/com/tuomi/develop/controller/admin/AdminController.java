package com.tuomi.develop.controller.admin;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.entity.Admin;
import com.tuomi.develop.service.AdminService;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @version: V1.0
 * @description: 管理员类
 * @date 2019/6/25 11:13
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/adminLogin",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String adminLogin( String username,String password,HttpServletRequest request){
        Admin admin = adminService.selectByNameAndPwd(username, password);
        String toJSONString = "";
        if(admin != null){
        	request.getSession().setAttribute("loginName", admin.getUsername());
            toJSONString = JSON.toJSONString(admin);
        }
        return toJSONString;
    }

    @RequestMapping(value = "/adminRegist",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String adminRegist( String username,String password){
        String toJSONString = "";
        Admin admin1 = adminService.selectByName(username);
        if (admin1!=null){
            toJSONString = JSON.toJSONString("用户名重复！");
        }else{
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            int i = adminService.insertSelective(admin);
            toJSONString = JSON.toJSONString("注册成功！");
        }
        return toJSONString;
    }
    @RequestMapping("/logout")
    public String ma(HttpServletRequest request){
    	String path = request.getServletContext().getContextPath();
    	System.out.println(path);
    	request.getSession().removeAttribute("loginName");
    	return  "redirect:/login.html";
    }
    
    
}
