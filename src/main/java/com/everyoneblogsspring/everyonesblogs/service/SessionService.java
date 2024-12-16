package com.everyoneblogsspring.everyonesblogs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.RequestContextFilter;

import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SessionService {
   private final userRepository repository;
   private final JdbcIndexedSessionRepository sessionRepository;



@Scheduled(fixedDelay = 900*1000)
public void changeSession(){

   UUID id = UUID.fromString(request.getSession().getAttribute("id").toString());
   if(repository.findById(id).isPresent()){
      var e = repository.getReferenceById(id);
      String novaSessao = request.changeSessionId();
      e.setSessionID(novaSessao);
      repository.saveAndFlush(e);

   }

}



}
