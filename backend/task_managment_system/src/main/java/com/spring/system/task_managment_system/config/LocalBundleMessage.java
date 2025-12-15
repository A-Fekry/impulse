package com.spring.system.task_managment_system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class LocalBundleMessage {

    @Value("${spring.messages.basename:i18n/messages}")
    private String baseName;

    @Value("${spring.messages.locale:en}")
    private String localDefault;

    @Bean("messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(baseName);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(new Locale(localDefault));
        return messageSource;
    }
}

