package com.everyoneblogsspring.everyonesblogs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SessionService {
   private final userRepository repository;
@Autowired
@Getter
@Lazy
private Session sessao;
@Scheduled(fixedDelay = 900*1000)
public void changeSession(){
   if (sessao==null || sessao.getAttribute("id") == null) {
    return;
   }
   UUID id = UUID.fromString(sessao.getAttribute("id"));
   if(repository.findById(id).isPresent()){
      var e = repository.getReferenceById(id);
      String novaSessao = sessao.changeSessionId();
      e.setSessionID(novaSessao);
      repository.saveAndFlush(e);
   }

}



}
