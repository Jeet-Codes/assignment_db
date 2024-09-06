package com.softnerve.assignment.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean("modelx")
    public ModelMapper model() {
        return new ModelMapper();
    }
}
