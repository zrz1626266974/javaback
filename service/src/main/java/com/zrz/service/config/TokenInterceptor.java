package com.zrz.service.config;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        // 1、从请求头中获取token
        String amdin_token = request.getHeader("admin-token");
        String user_token = request.getHeader("user-token");

        

        System.out.println("token=" + amdin_token);
        // 2、判断 token 是否存在
        if ((amdin_token == null || "".equals(amdin_token)) &&
                (user_token == null || "".equals(user_token))) {
            System.out.println("未登录");
            return false;
        }
        // 3、解析token
//        if(!TokenUtil.verify(token)){
//            return false;
//        }
        return true;
    }
}
