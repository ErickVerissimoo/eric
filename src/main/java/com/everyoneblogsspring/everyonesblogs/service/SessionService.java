package com.everyoneblogsspring.everyonesblogs.service;

import java.util.Map;
import java.util.UUID;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessionService {

    private final userRepository repository;
    private final JdbcIndexedSessionRepository sessionRepository;
    private final Map<String, String> map;

    @Scheduled(fixedDelay = 4500)
    public void changeSession() {
        if (map.isEmpty() || map.size()> 1) {
            log.warn("Nenhuma sessão associada ou mais de uma sessão ativa.");
            return;
        }

        try {
            String username = getUsername();
            User user = repository.findByUsername(username);

            Session novaSessao = sessionRepository.createSession();
            String newSessionId = novaSessao.changeSessionId();

            user.setSessionID(newSessionId);
            repository.save(user);

            log.info("Sessão trocada com sucesso para o usuário: {}", username + "para a sessão: " + newSessionId);
        } catch (Exception e) {
            log.error("Erro ao trocar sessão: {}", e.getMessage(), e);
        }
    }

    public void addSession(String sessionId, String username) {
        if (map.containsKey(username)) {
            log.warn("Sessão já associada para o usuário: {}", username);
        } else {
            map.putIfAbsent(username, sessionId);
            log.info("Sessão adicionada para o usuário: {}", username);
        }
    }

    public void removeSession(String userId) {
        try {
            User user = repository.findById(UUID.fromString(userId))
                                  .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + userId));

            map.remove(user.getUsername());
            log.info("Sessão removida para o usuário: {}", user.getUsername());
        } catch (Exception e) {
            log.error("Erro ao remover sessão: {}", e.getMessage(), e);
        }
    }

    private String getUsername() {
        return map.keySet()
                  .stream()
                  .findFirst()
                  .orElseThrow(() -> new RuntimeException("Nenhum usuário associado à sessão"));
    }
}
