package com.everyoneblogsspring.everyonesblogs.filter;

import java.nio.charset.Charset;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class AuthenticatedHandler  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {
                                response.setCharacterEncoding(Charset.defaultCharset().name());

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            if (method.hasMethodAnnotation(Authenticated.class) || method.getBeanType().isAnnotationPresent(Authenticated.class) || method.getMethod().isAnnotationPresent(Authenticated.class)) {
                if(Objects.nonNull(request.getSession(false))){
log.info(() -> "Usuário autenticado");
return true;
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                    return false;}
            }} return true;
            }

}
