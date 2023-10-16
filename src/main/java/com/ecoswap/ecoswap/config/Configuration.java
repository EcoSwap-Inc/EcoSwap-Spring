package com.ecoswap.ecoswap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@org.springframework.context.annotation.Configuration
public class Configuration {
    // Necessário para validação de @RequestParam funcionar
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}