package com.everyoneblogsspring.everyonesblogs.filter;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class AuthenticatedHandler  implements HandlerInterceptor{
@Override
public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler)
        throws Exception {
    if(handler instanceof HandlerMethod){
        HandlerMethod method = (HandlerMethod)handler;
        if(method.hasMethodAnnotation(Authenticated.class) && request.getSession(false)!=null){
           response.getWriter().write("Usuário autenticado");
           response.setStatus(HttpServletResponse.SC_ACCEPTED);
           return true; 
        }

    }
    response.getWriter().write("Usuário não autenticado");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    return false;
}
}
