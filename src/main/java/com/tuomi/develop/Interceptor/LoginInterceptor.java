package com.tuomi.develop.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	 @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
             throws Exception {
     	// 检查每个到来的请求对应的session域中是否有登录标识
         Object loginName = request.getSession().getAttribute("loginName");
         if (null == loginName || !(loginName instanceof String)) {
             // 未登录，重定向到登录页
             response.sendRedirect("/develop/login.html");
             return false;
         }
         String userName = (String) loginName;
         System.out.println("当前用户已登录，登录的用户名为： " + userName);
         return true;
     }
	
}
