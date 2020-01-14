package com.sprmvc.web.ch5.config;

import com.sprmvc.web.ch5.services.SpitterService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.sprmvc.web.ch5"},
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource =
//                new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("");
//        messageSource.setCacheSeconds(10);
//        return messageSource;
//    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
//        messageSource.setBasename("messages_es");
        return messageSource;
    }


}
