package com.javaunit3.springmvc;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class HibernateConfig {

    SessionFactory factory = (SessionFactory) new org.hibernate.cfg.Configuration();

    @Bean
    public SessionFactory factory() {
        .configure
    }
}
