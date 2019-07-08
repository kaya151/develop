package com.tuomi.develop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.entity.Im;
import com.tuomi.develop.entity.User;
import com.tuomi.develop.entity.UserInfo;
import com.tuomi.develop.service.ImService;
import com.tuomi.develop.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	private final static String WECHAT="1";
	private final static String QQ="2";
	
	@Autowired
	private ImService imService;
	@Autowired 
	private UserInfoService userInfoService;
	/**
	 * 
	 * @param im
	 * @return
	 */
	@RequestMapping(value = "/auth",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult auth(Im im) {
		BaseResult baseResult = null;
    	//判断是那种登录方式微信还是qq
		if(WECHAT.equals(im.getTypes())) {
			//如果是微信,是否存在数据库中
			Im imNew1 = imService.findImByOpenId(im.getOpenId());
			if(imNew1==null) {
				//不存在就是新数据，就存入数据库
				int wechatId = imService.save(im);
				UserInfo u = new UserInfo();
				u.setImWeChatId(im);
				//用户表新增用户绑定微信
				int uid = userInfoService.save(u);
				UserInfo user = userInfoService.getUserById(Long.parseLong(uid+""));
				baseResult = new BaseResult(1,"新用户微信登录成功",user);
			}else {
				//不是新数据 获取user信息
				UserInfo info = userInfoService.findUserByWeChatId(imNew1.getId());
				baseResult = new BaseResult(1,"老用户微信登录成功",info);
			}
		}else if(QQ.equals(im.getTypes())){//如果是qq登录
			//如果是qq，是否是存在数据库的
			Im imNew2 = imService.findImByOpenId(im.getOpenId());
			if(imNew2==null) {
				//不存在，就是第一次qq登录,存入数据库
				int wechatId = imService.save(im);
				UserInfo u = new UserInfo();
				u.setImQqId(im);
				//新增用户绑定 qq
				int uid = userInfoService.save(u);
				UserInfo user = userInfoService.getUserById(Long.parseLong(uid+""));
				baseResult = new BaseResult(1,"新用户qq微信登录成功",user);
			}else {
				//不是新数据 获取user信息
				UserInfo info = userInfoService.findUserByQQId(imNew2.getId());
				baseResult = new BaseResult(1,"老用户微信登录成功",info);
			}
		}
		return baseResult;
    }
	@RequestMapping(value = "/bindingPhone",method = RequestMethod.POST)
	@ResponseBody
	public BaseResult binding(HttpSession session,Long id, String tel, String newAuthCode){
		BaseResult baseResult = null;
		String frontRandomNum = (String) session.getAttribute(tel);
		if(frontRandomNum.equals(newAuthCode)) {
			UserInfo userInfo = userInfoService.findUserById(id);
			userInfo.setTel(tel);
			int i = userInfoService.edit(userInfo);
			if (i == 1){
                baseResult = new BaseResult(1,"手机号绑定成功",userInfo);
            }else {
                baseResult = new BaseResult(0,"手机号绑定失败");
            }
		}else {
			baseResult = new BaseResult(0,"验证码错误");
		}
		return baseResult;
	}
	
	
}
