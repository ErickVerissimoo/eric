package com.everyoneblogsspring.everyonesblogs.filter;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Objects;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
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
                                response.setCharacterEncoding(Charset.defaultCharset().name());

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            if (method.hasMethodAnnotation(Authenticated.class)) {
                if(Objects.nonNull(request.getSession(false))){
                    
return true;
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                    return false;}
            }} return true;
            }

}
