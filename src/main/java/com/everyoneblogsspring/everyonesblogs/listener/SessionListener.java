package com.everyoneblogsspring.everyonesblogs.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {
    private final userRepository repository;
    
    public SessionListener(userRepository repository){
        this.repository=repository;
    }
    @Override
public void sessionCreated(HttpSessionEvent se) {
String sessionId = se.getSession().getId();
HttpSession sessao = se.getSession();
UUID uuid = UUID.fromString(sessao.getAttribute("id").toString());
User user = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
user.setSessionID(sessionId);
repository.saveAndFlush(user);
}
}
