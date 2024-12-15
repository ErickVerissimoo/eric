package com.everyoneblogsspring.everyonesblogs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
public ModelMapper mapperFactory(){
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setSkipNullEnabled(true);
    return mapper;
}
}
