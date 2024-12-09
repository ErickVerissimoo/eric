package com.everyoneblogsspring.everyonesblogs.filter;

import java.awt.List;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            if (method.hasMethodAnnotation(Authenticated.class)) {
                if(request.getSession(false) !=null){
                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                    response.getWriter().write("Usuário autenticado");
                    response.setStatus(HttpServletResponse.SC_OK);  
                    response.getWriter().flush(); 
                    
                    return true;  
                } else{
                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                    response.getWriter().write("Usuário não autenticado");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  
                    response.getWriter().flush(); 
                    return false;  
                }
               
            } 
        }
return true;
   
    }
}

