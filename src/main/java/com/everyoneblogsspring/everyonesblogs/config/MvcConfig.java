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
@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
public class MvcConfig implements WebMvcConfigurer{
     private final AuthenticatedHandler handler;

     public MvcConfig(AuthenticatedHandler handler) {
        this.handler=handler;
     }

    @Override
public void addInterceptors(@NonNull InterceptorRegistry registry) {
registry.addInterceptor(handler);
}
@Bean
public RequestContextFilter requestFilter(){
   return new RequestContextFilter();
}
}
