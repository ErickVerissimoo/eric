package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Service
public class SessionService {
@Autowired
private Session sessao;
@Scheduled(fixedDelay = 2500)
public void changeSessionId(){
    if(this.sessao !=null)
    {

        System.out.println("O atributo é: "  + sessao.getAttribute("id").toString());
    }
    else
    System.out.println("nulo");
}
public Session getSession(){
    if(sessao == null){
        sessao = session.createSession();
        return sessao;
    }
    return sessao;
}
}
