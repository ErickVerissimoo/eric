package com.everyoneblogsspring.everyonesblogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.everyoneblogsspring.everyonesblogs.aspects.loggingAspect;
import com.everyoneblogsspring.everyonesblogs.filter.AuthenticatedHandler;
@EnableWebMvc
@EnableAspectJAutoProxy
@Import({loggingAspect.class})
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    @Autowired private AuthenticatedHandler handler;
    @Override
public void addInterceptors(@NonNull InterceptorRegistry registry) {
registry.addInterceptor(handler);
}
}
