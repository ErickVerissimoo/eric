package com.everyoneblogsspring.everyonesblogs.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class AuthenticatedHandler  implements HandlerInterceptor{
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
    if(handler instanceof HandlerMethod){
        HandlerMethod method = (HandlerMethod)handler;
        if(method.hasMethodAnnotation(Authenticated.class) && request.getSession(false)!=null){
           return true; 
        }

    }
    return false;
}
}
