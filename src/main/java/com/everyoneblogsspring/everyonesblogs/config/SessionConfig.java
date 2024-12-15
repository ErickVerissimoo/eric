package com.everyoneblogsspring.everyonesblogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Configuration
@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 900*1000)
public class SessionConfig {
 private final JdbcIndexedSessionRepository repository;

@Bean
@Lazy
@Scope("session")
public Session getSession(){

return repository.createSession();
}

}
