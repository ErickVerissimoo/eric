package com.everyoneblogsspring.everyonesblogs.filter;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.session.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.everyoneblogsspring.everyonesblogs.repository.userRepository;
import com.everyoneblogsspring.everyonesblogs.utils.ChangeSession;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class ChangeSessionInterceptor implements HandlerInterceptor {
    private final userRepository repository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

if(handler instanceof HandlerMethod){
HandlerMethod method = (HandlerMethod) handler;
if(method.hasMethodAnnotation(ChangeSession.class) && Objects.nonNull(WebUtils.getCookie(request, "session_id")) && Objects.nonNull(WebUtils.getSessionAttribute(request, "id"))){
    try{
    Cookie cook = WebUtils.getCookie(request, "session_id");
UUID id = UUID.fromString(WebUtils.getSessionAttribute(request, "id").toString());
var user =repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User não encontrado"));

    Session session =(Session) request.getSession(false);
cook.setValue(session.changeSessionId());
response.addCookie(cook);
user.setSessionID(session.changeSessionId());
repository.saveAndFlush(user);
return true;
}catch(Exception e){
    response.setStatus(HttpStatus.BAD_REQUEST.value());
return false;
}



}

}
     return true;       }}
