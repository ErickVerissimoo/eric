package com.everyoneblogsspring.everyonesblogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.everyoneblogsspring.everyonesblogs.filter.AuthenticatedHandler;

import lombok.RequiredArgsConstructor;
@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer{
     private final AuthenticatedHandler handler;
    @Override
public void addInterceptors(@NonNull InterceptorRegistry registry) {
registry.addInterceptor(handler);
}


}
