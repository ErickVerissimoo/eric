package com.everyoneblogsspring.everyonesblogs.filter;

import java.util.Objects;

import org.springframework.context.annotation.Description;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
@Description("""
Interceptor para verificar em tempo de execução
se o método de controlador que está prestes a ser chamado
possui a anotação @Authenticated
        """)
public class AuthenticatedHandler  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            if (!ObjectUtils.isEmpty(AnnotationUtils.findAnnotation(method.getMethod(), Authenticated.class))) {
                if(Objects.nonNull(request.getSession(false))){

log.info(() -> "Usuário autenticado");
return true;
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                    return false;}
            }return true; }return true;
            }

}
