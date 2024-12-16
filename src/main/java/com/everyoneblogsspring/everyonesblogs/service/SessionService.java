package com.everyoneblogsspring.everyonesblogs.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Scope("request")
@Log4j2

@RequiredArgsConstructor
public class SessionService {
   private final userRepository repository;
   private HttpServletRequest request;


@Scheduled(fixedDelay = 900*1000)
public void changeSession(){
log.info("prestes a ser executado");
if (request == null) {
   return;
}

  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String sessionId = request.getSession().getId();
        System.out.println("Session ID: " + sessionId);




   HttpSession sessao = request.getSession(true);
   if (Objects.nonNull(sessao.getAttribute("id"))) {
      UUID id =UUID.fromString(sessao.getAttribute("id").toString());

      if(repository.findById(id).isPresent()){
         var e = repository.getReferenceById(id);
         String novaSessao = sessao.getId();
         e.setSessionID(novaSessao);
         repository.saveAndFlush(e);
   }

   }
return;
}



}
