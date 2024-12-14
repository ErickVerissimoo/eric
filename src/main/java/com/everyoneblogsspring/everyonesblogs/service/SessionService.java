package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import lombok.Getter;
@Service
public class SessionService {
@Autowired
@Getter
@Lazy
private Session sessao;
@Scheduled(fixedDelay = 900*1000)
public void changeSessionId(){
   if (sessao==null || sessao.getAttribute("id") == null) {
    return;
   }
   String id = sessao.getAttribute("id");
   System.out.println("O id do usuário é: " + id);

}



}
