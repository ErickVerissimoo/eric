package com.everyoneblogsspring.everyonesblogs.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Configuration
@EnableJdbcHttpSession
public class SessionConfig {



}
